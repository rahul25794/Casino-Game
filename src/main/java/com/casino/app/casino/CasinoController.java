package com.casino.app.casino;

import java.util.List;

import com.casino.app.dealer.DealerRepository;
import com.casino.app.game.GameRepository;
import com.casino.app.objects.Casino;
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
@RequestMapping(CasinoController.BASE_URL)
public class CasinoController {
    public static final String BASE_URL = "casinos";
    @Autowired
    public CasinoRepository casinoRepo;
    @Autowired
    public DealerRepository dealerRepo;
    @Autowired
    public GameRepository gameRepo;

    @GetMapping()
    public List<Casino> list() throws Exception {
        return casinoRepo.getAll();
    }
    @GetMapping(value = "/{id}")
    public Casino get(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return casinoRepo.get(id);
    }

    @PostMapping()
    public Casino register(@RequestParam(required = true) String name, @RequestParam(required = false) Double balance) {
        return casinoRepo.create(name, balance);
    }
    @PostMapping(value = "/{id}/recharge")
    public Casino recharge(@PathVariable(value = "id", required = true) Integer id,
            @RequestParam(required = true) Double amount) throws Exception {
        return casinoRepo.addBalance(id, amount);
    }

    @GetMapping(value = "/{id}/dealers")
    public List<Dealer> listDealers(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return dealerRepo.list(id);
    }
    @GetMapping(value = "/{id}/games")
    public List<Game> listGames(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return gameRepo.getAllOpen(id);
    }
}