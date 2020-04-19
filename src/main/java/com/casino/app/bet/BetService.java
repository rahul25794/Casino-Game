package com.casino.app.bet;

import com.casino.app.exception.ApiException;
import com.casino.app.game.GameRepository;
import com.casino.app.objects.Bet;
import com.casino.app.objects.Game;
import com.casino.app.objects.User;
import com.casino.app.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private GameRepository gameRepo;

    public Bet placeBet(Integer userId, Integer gameId, Double amount, Integer number) throws Exception {
        if(number<=0 || number>36){
            throw new ApiException("Invalid number");
        }
        Game game = gameRepo.get(gameId);
        if (game.status != Game.STATUS.OPEN) {
            throw new ApiException("Game is already closed");
        }
        User user = userRepo.get(userId);
        if (user.casinoId == null || game.casinoId != user.casinoId) {
            throw new ApiException("You are in a different casino");
        }
        return betRepo.create(userId, gameId, game.casinoId, amount, number);
    }
}