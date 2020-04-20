package com.casino.app.game;

import java.util.List;

import com.casino.app.dealer.DealerRepository;
import com.casino.app.objects.Dealer;
import com.casino.app.objects.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(GameController.BASE_URL)
public class GameController {
    public static final String BASE_URL = "games";
    @Autowired
    public GameRepository gameRepo;
    @Autowired
    public DealerRepository dealerRepo;
    @Autowired
    public GameService gameService;

    @GetMapping()
    public List<Game> listOpenGames(@RequestParam(required = true) Integer casinoId) throws Exception {
        return gameRepo.getAllOpen(casinoId);
    }

    @PostMapping()
    public Game create(@RequestParam(required = true) Integer dealerId) throws Exception {
        Dealer dealer = dealerRepo.get(dealerId);
        return gameRepo.create(dealer.casinoId, dealerId);
    }

    @PostMapping(value = "/{id}/stop")
    public Game stop(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return gameService.stopGame(id);
    }
}