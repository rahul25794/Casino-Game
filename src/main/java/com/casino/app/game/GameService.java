package com.casino.app.game;

import java.util.List;
import java.util.Random;

import com.casino.app.bet.BetRepository;
import com.casino.app.casino.CasinoRepository;
import com.casino.app.exception.ApiException;
import com.casino.app.objects.Bet;
import com.casino.app.objects.Game;
import com.casino.app.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private BetRepository betRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CasinoRepository casinoRepo;
    @Autowired
    private GameRepository gameRepo;

    public Game stopGame(Integer id) throws Exception{
        Game game = gameRepo.get(id);
        if(game.status!=Game.STATUS.OPEN){
            throw new ApiException("Game is already closed");
        }
        Integer number = 2;//new Random().nextInt(35) + 1;
        List<Bet> bets = betRepo.updateWonBets(id, number);
        betRepo.updateLostBets(id, number);
        userRepo.updateWonBetBalance(bets);
        Double sum = bets.stream().map(bet -> {
            return bet.amount*2;
        }).reduce(0.0, Double::sum);
        casinoRepo.subtractBalance(game.casinoId, sum);
        return gameRepo.stop(id, number);
    }
}