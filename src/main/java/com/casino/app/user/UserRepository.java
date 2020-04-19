package com.casino.app.user;

import java.util.List;
import java.util.stream.Collectors;

import com.casino.app.db.BaseRepository;
import com.casino.app.exception.ApiException;
import com.casino.app.objects.Bet;
import com.casino.app.objects.User;
import com.casino.jooq.db.tables.Users;
import com.casino.jooq.db.tables.records.UsersRecord;

import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserRepository extends BaseRepository<User>{
    private static final Users TBL = Users.USERS;
    private final DSLContext DB;
    @Autowired
    public UserRepository(DSLContext dsl){
        this.DB = dsl;
    }
    public User get(Integer id) throws Exception{
        return r(DB.select()
            .from(TBL)
            .where(TBL.ID.eq(id))
            .fetchOne(),User.class);
    }
    public User create(String name, Double amt) throws Exception{
        amt = amt==null? 0.0:amt;
        return r(DB.insertInto(TBL)
            .columns(TBL.NAME, TBL.BALANCE)
            .values(name,amt)
            .returning().fetchOne(),User.class);
    }
    public User addBalance(Integer id, Double amount) throws Exception{
        DB.update(TBL)
            .set(TBL.BALANCE, TBL.BALANCE.add(amount))
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
    }
    public User subtractBalance(Integer id, Double amount) throws Exception{
        User user = get(id);
        if(user.balance-amount<0){
            throw new ApiException("Insufficient balance.");
        }
        DB.update(TBL)
            .set(TBL.BALANCE, TBL.BALANCE.subtract(amount))
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
    }
    public User resetBalance(Integer id) throws Exception{
        DB.update(TBL)
            .set(TBL.BALANCE, 0.0)
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
    }
    public User updateCasino(Integer id, Integer casinoId) throws Exception{
        DB.update(TBL)
            .set(TBL.CASINOID, casinoId)
            .where(TBL.ID.eq(id))
            .execute();
        return get(id);
        
    }
    public void updateWonBetBalance(List<Bet> bets) throws Exception{
        BatchBindStep q = DB.batch(DB.update(TBL)
            .set(TBL.BALANCE,TBL.BALANCE.add((Integer)null))
            .where(TBL.ID.eq((Integer)null)));
        for(Bet bet:bets){
            Double amount = (bet.amount*2);
            q.bind(amount,bet.userId);
        }
        q.execute();
    }
}