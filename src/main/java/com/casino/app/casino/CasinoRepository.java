package com.casino.app.casino;

import java.util.List;

import com.casino.app.db.BaseRepository;
import com.casino.app.exception.ApiException;
import com.casino.app.objects.Casino;
import com.casino.jooq.db.tables.Casinos;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CasinoRepository extends BaseRepository<Casino>{
    private static final Casinos TBL = Casinos.CASINOS;
    private final DSLContext DB;
    @Autowired
    public CasinoRepository(DSLContext dsl){
        this.DB = dsl;
    }
    public List<Casino> getAll() throws Exception{
        return DB.select()
            .from(TBL)
            .fetchInto(Casino.class);
    }
    public Casino create(String name, Double amt){
        amt = amt==null? 0.0:amt;
        return DB.insertInto(TBL)
            .columns(TBL.NAME, TBL.BALANCE)
            .values(name,amt)
            .returning().fetchOne().into(Casino.class);
    }
    public Casino get(Integer id) throws Exception{
        return r(DB.select()
            .from(TBL)
            .where(TBL.ID.eq(id))
            .fetchOne(), Casino.class);
    }
    public Casino addBalance(Integer id, Double amount) throws Exception{
        DB.update(TBL)
            .set(TBL.BALANCE, TBL.BALANCE.add(amount))
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
    }
    public Casino subtractBalance(Integer id, Double amount) throws Exception{
        Casino casino = get(id);
        if(casino.balance-amount<0){
            throw new ApiException("Insufficient balance.");
        }
        DB.update(TBL)
            .set(TBL.BALANCE, TBL.BALANCE.subtract(amount))
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
    }
}