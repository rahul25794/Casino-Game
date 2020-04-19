package com.casino.app.bet;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import com.casino.app.casino.CasinoRepository;
import com.casino.app.db.BaseRepository;
import com.casino.app.exception.ApiException;
import com.casino.app.game.GameRepository;
import com.casino.app.objects.Bet;
import com.casino.app.objects.Game;
import com.casino.app.objects.User;
import com.casino.app.user.UserRepository;
import com.casino.jooq.db.tables.Bets;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BetRepository extends BaseRepository<Bet>{
    private static final Bets TBL = Bets.BETS;
    private final DSLContext DB;
    @Autowired
    public CasinoRepository casinoRepo;
    @Autowired
    public GameRepository gameRepo;
    @Autowired
    public UserRepository userRepo;
    @Autowired
    public BetRepository(DSLContext dsl){
        this.DB = dsl;
    }
    public List<Bet> getAllBetsForUser(Integer userId){
        return DB
            .select()
            .from(TBL)
            .where(TBL.USERID.eq(userId))
            .fetchInto(Bet.class);
    }
    public Bet get(Integer id) throws Exception{
        return r(DB
            .select()
            .from(TBL)
            .where(TBL.ID.eq(id))
            .fetchOne(),Bet.class);
    }
    public Bet create(Integer userId, Integer gameId, Integer casinoId,Double amount,Integer number) throws Exception{
        userRepo.subtractBalance(userId,amount);
        casinoRepo.addBalance(casinoId, amount);
        return DB
            .insertInto(TBL)
            .columns(TBL.USERID, TBL.GAMEID, TBL.AMOUNT, TBL.TIME,TBL.NUMBER)
            .values(userId, gameId, amount, Timestamp.from(Instant.now()),number)
            .returning().fetchOne().into(Bet.class);
    }
    public List<Bet> updateWonBets(Integer gameId,Integer number) throws Exception{
        DB.update(TBL)
            .set(TBL.STATUS, Bet.STATUS.WON.name())
            .where(TBL.GAMEID.eq(gameId)
                .and(TBL.NUMBER.eq(number)))
            .execute();
        List<Bet> bets= DB.select()
            .from(TBL)
            .where(TBL.GAMEID.eq(gameId)
                .and(TBL.NUMBER.eq(number))
                .and(TBL.STATUS.eq(Bet.STATUS.WON.name())))
            .fetchInto(Bet.class);
        return bets;
    }
    public List<Bet> updateLostBets(Integer gameId,Integer number) throws Exception{
        DB.update(TBL)
            .set(TBL.STATUS, Bet.STATUS.LOST.name())
            .where(TBL.GAMEID.eq(gameId)
                .and(TBL.NUMBER.ne(number)))
            .execute();
        List<Bet> bets= DB.select()
            .from(TBL)
            .where(TBL.GAMEID.eq(gameId)
                .and(TBL.NUMBER.eq(number))
                .and(TBL.STATUS.eq(Bet.STATUS.LOST.name())))
            .fetchInto(Bet.class);
        return bets;
    }
}