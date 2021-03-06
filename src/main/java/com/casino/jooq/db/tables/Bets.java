/*
 * This file is generated by jOOQ.
 */
package com.casino.jooq.db.tables;


import com.casino.jooq.db.Casino;
import com.casino.jooq.db.Indexes;
import com.casino.jooq.db.Keys;
import com.casino.jooq.db.tables.records.BetsRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bets extends TableImpl<BetsRecord> {

    private static final long serialVersionUID = -914324642;

    /**
     * The reference instance of <code>casino.bets</code>
     */
    public static final Bets BETS = new Bets();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BetsRecord> getRecordType() {
        return BetsRecord.class;
    }

    /**
     * The column <code>casino.bets.id</code>.
     */
    public final TableField<BetsRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>casino.bets.amount</code>.
     */
    public final TableField<BetsRecord, Double> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>casino.bets.time</code>.
     */
    public final TableField<BetsRecord, Timestamp> TIME = createField(DSL.name("time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>casino.bets.userId</code>.
     */
    public final TableField<BetsRecord, Integer> USERID = createField(DSL.name("userId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>casino.bets.gameId</code>.
     */
    public final TableField<BetsRecord, Integer> GAMEID = createField(DSL.name("gameId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>casino.bets.status</code>.
     */
    public final TableField<BetsRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false).defaultValue(org.jooq.impl.DSL.inline("PLACED", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>casino.bets.number</code>.
     */
    public final TableField<BetsRecord, Integer> NUMBER = createField(DSL.name("number"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>casino.bets</code> table reference
     */
    public Bets() {
        this(DSL.name("bets"), null);
    }

    /**
     * Create an aliased <code>casino.bets</code> table reference
     */
    public Bets(String alias) {
        this(DSL.name(alias), BETS);
    }

    /**
     * Create an aliased <code>casino.bets</code> table reference
     */
    public Bets(Name alias) {
        this(alias, BETS);
    }

    private Bets(Name alias, Table<BetsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bets(Name alias, Table<BetsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Bets(Table<O> child, ForeignKey<O, BetsRecord> key) {
        super(child, key, BETS);
    }

    @Override
    public Schema getSchema() {
        return Casino.CASINO;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BETS_GAME_BET_IDX, Indexes.BETS_GAME_USER_IDX, Indexes.BETS_ID_UNIQUE, Indexes.BETS_PRIMARY);
    }

    @Override
    public Identity<BetsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BETS;
    }

    @Override
    public UniqueKey<BetsRecord> getPrimaryKey() {
        return Keys.KEY_BETS_PRIMARY;
    }

    @Override
    public List<UniqueKey<BetsRecord>> getKeys() {
        return Arrays.<UniqueKey<BetsRecord>>asList(Keys.KEY_BETS_PRIMARY, Keys.KEY_BETS_ID_UNIQUE);
    }

    @Override
    public List<ForeignKey<BetsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BetsRecord, ?>>asList(Keys.GAME_USER, Keys.GAME_BET);
    }

    public Users users() {
        return new Users(this, Keys.GAME_USER);
    }

    public Games games() {
        return new Games(this, Keys.GAME_BET);
    }

    @Override
    public Bets as(String alias) {
        return new Bets(DSL.name(alias), this);
    }

    @Override
    public Bets as(Name alias) {
        return new Bets(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bets rename(String name) {
        return new Bets(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bets rename(Name name) {
        return new Bets(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Double, Timestamp, Integer, Integer, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
