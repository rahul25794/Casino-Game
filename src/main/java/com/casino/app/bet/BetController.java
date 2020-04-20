package com.casino.app.bet;

import java.util.List;

import com.casino.app.game.GameRepository;
import com.casino.app.objects.Bet;
import com.casino.app.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BetController.BASE_URL)
public class BetController {
    public static final String BASE_URL = "bets";
    @Autowired
    public GameRepository gameRepo;
    @Autowired
    public UserRepository userRepo;
    @Autowired
    public BetRepository betRepo;
    @Autowired
    public BetService betService;

    @PostMapping()
    public Bet placeBet(@RequestParam(required = true) Integer userId, @RequestParam(required = true) Integer gameId,
            @RequestParam(required = true) Double amount, @RequestParam(required = true) Integer number)
            throws Exception {
        return betService.placeBet(userId, gameId, amount, number);
    }

    @GetMapping(value = "/{id}")
    public Bet get(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return betRepo.get(id);
    }
    @GetMapping()
    public List<Bet> getAllBets(@RequestParam(required = true) Integer userId) throws Exception {
        return betRepo.getAllBetsForUser(userId);
    }
}