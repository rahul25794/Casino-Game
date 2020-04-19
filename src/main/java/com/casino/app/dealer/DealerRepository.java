package com.casino.app.dealer;

import java.util.List;

import com.casino.app.db.BaseRepository;
import com.casino.app.objects.Dealer;
import com.casino.jooq.db.tables.Dealers;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DealerRepository extends BaseRepository<Dealer>{
    private static final Dealers TBL = Dealers.DEALERS;
    private final DSLContext DB;

    @Autowired
    public DealerRepository(DSLContext dsl) {
        this.DB = dsl;
    }

    public Dealer get(Integer id) throws Exception{
        return r(DB.select()
            .from(TBL)
            .where(TBL.ID.eq(id))
            .fetchOne(),Dealer.class);
    }

    public Dealer create(String name, Integer casinoId) throws Exception{
        return r(DB.insertInto(TBL)
            .columns(TBL.NAME, TBL.CASINOID)
            .values(name, casinoId)
            .returning().fetchOne(),Dealer.class);
    }
    public List<Dealer> list(Integer casinoId) throws Exception{
        return DB.select()
            .from(TBL)
            .where(TBL.CASINOID.eq(casinoId))
            .fetchInto(Dealer.class);
    }
}