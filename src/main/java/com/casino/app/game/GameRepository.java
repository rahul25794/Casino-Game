package com.casino.app.game;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import com.casino.app.db.BaseRepository;
import com.casino.app.objects.Game;
import com.casino.jooq.db.tables.Games;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class GameRepository extends BaseRepository<Game>{
    private static final Games TBL = Games.GAMES;
    private final DSLContext DB;
    @Autowired
    public GameRepository(DSLContext dsl){
        this.DB = dsl;
    }
    public Game get(Integer gameId) throws Exception{
        return r(DB.select()
            .from(TBL)
            .where(TBL.ID.eq(gameId))
            .fetchOne(),Game.class);
    }
    public List<Game> getAllOpen(Integer casinoId){
        return DB.select()
            .from(TBL)
            .where(TBL.STATUS.eq(Game.STATUS.OPEN.name())
                .and(TBL.CASINOID.eq(casinoId)))
            .fetchInto(Game.class);
    }
    public Game create(Integer casinoId, Integer dealerId) throws Exception{
        return r(DB.insertInto(TBL)
            .columns(TBL.START,TBL.CASINOID, TBL.DEALERID)
            .values(Timestamp.from(Instant.now()),casinoId,dealerId)
            .returning().fetchOne(),Game.class);
    }
    public Game stop(Integer id, Integer number) throws Exception{
        DB.update(TBL)
            .set(TBL.END, Timestamp.from(Instant.now()))
            .set(TBL.STATUS, Game.STATUS.CLOSED.name())
            .set(TBL.NUMBER, number)
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
    }
}