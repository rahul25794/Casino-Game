package com.casino.app.user;

import java.util.List;

import com.casino.app.bet.BetRepository;
import com.casino.app.objects.Bet;
import com.casino.app.objects.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "users";
    @Autowired
    public UserRepository userRepo;
    @Autowired
    public BetRepository betRepo;

    @PostMapping()
    public User register(@RequestParam(required = true) String name, @RequestParam(required = false) Double balance)
            throws Exception {
        return userRepo.create(name, balance);
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return userRepo.get(id);
    }

    @PostMapping(value = "/{id}/join")
    public User join(@PathVariable(value = "id", required = true) Integer id,
            @RequestParam(required = true) Integer casinoId) throws Exception {
        return userRepo.updateCasino(id, casinoId);
    }

    @PostMapping(value = "/{id}/recharge")
    public User recharge(@PathVariable(value = "id", required = true) Integer id,
            @RequestParam(required = true) Double amount) throws Exception {
        return userRepo.addBalance(id, amount);
    }

    @GetMapping(value = "/{id}/bets")
    public List<Bet> getAllBets(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return betRepo.getAllBetsForUser(id);
    }

}