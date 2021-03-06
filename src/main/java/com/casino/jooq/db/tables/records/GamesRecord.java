/*
 * This file is generated by jOOQ.
 */
package com.casino.jooq.db.tables.records;


import com.casino.jooq.db.tables.Games;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


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
public class GamesRecord extends UpdatableRecordImpl<GamesRecord> implements Record7<Integer, Timestamp, Timestamp, String, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1391862410;

    /**
     * Setter for <code>casino.games.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>casino.games.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>casino.games.start</code>.
     */
    public void setStart(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>casino.games.start</code>.
     */
    public Timestamp getStart() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>casino.games.end</code>.
     */
    public void setEnd(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>casino.games.end</code>.
     */
    public Timestamp getEnd() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>casino.games.status</code>.
     */
    public void setStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>casino.games.status</code>.
     */
    public String getStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>casino.games.number</code>.
     */
    public void setNumber(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>casino.games.number</code>.
     */
    public Integer getNumber() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>casino.games.casinoId</code>.
     */
    public void setCasinoid(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>casino.games.casinoId</code>.
     */
    public Integer getCasinoid() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>casino.games.dealerId</code>.
     */
    public void setDealerid(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>casino.games.dealerId</code>.
     */
    public Integer getDealerid() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Timestamp, Timestamp, String, Integer, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, Timestamp, Timestamp, String, Integer, Integer, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Games.GAMES.ID;
    }

    @Override
    public Field<Timestamp> field2() {
        return Games.GAMES.START;
    }

    @Override
    public Field<Timestamp> field3() {
        return Games.GAMES.END;
    }

    @Override
    public Field<String> field4() {
        return Games.GAMES.STATUS;
    }

    @Override
    public Field<Integer> field5() {
        return Games.GAMES.NUMBER;
    }

    @Override
    public Field<Integer> field6() {
        return Games.GAMES.CASINOID;
    }

    @Override
    public Field<Integer> field7() {
        return Games.GAMES.DEALERID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Timestamp component2() {
        return getStart();
    }

    @Override
    public Timestamp component3() {
        return getEnd();
    }

    @Override
    public String component4() {
        return getStatus();
    }

    @Override
    public Integer component5() {
        return getNumber();
    }

    @Override
    public Integer component6() {
        return getCasinoid();
    }

    @Override
    public Integer component7() {
        return getDealerid();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Timestamp value2() {
        return getStart();
    }

    @Override
    public Timestamp value3() {
        return getEnd();
    }

    @Override
    public String value4() {
        return getStatus();
    }

    @Override
    public Integer value5() {
        return getNumber();
    }

    @Override
    public Integer value6() {
        return getCasinoid();
    }

    @Override
    public Integer value7() {
        return getDealerid();
    }

    @Override
    public GamesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public GamesRecord value2(Timestamp value) {
        setStart(value);
        return this;
    }

    @Override
    public GamesRecord value3(Timestamp value) {
        setEnd(value);
        return this;
    }

    @Override
    public GamesRecord value4(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public GamesRecord value5(Integer value) {
        setNumber(value);
        return this;
    }

    @Override
    public GamesRecord value6(Integer value) {
        setCasinoid(value);
        return this;
    }

    @Override
    public GamesRecord value7(Integer value) {
        setDealerid(value);
        return this;
    }

    @Override
    public GamesRecord values(Integer value1, Timestamp value2, Timestamp value3, String value4, Integer value5, Integer value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GamesRecord
     */
    public GamesRecord() {
        super(Games.GAMES);
    }

    /**
     * Create a detached, initialised GamesRecord
     */
    public GamesRecord(Integer id, Timestamp start, Timestamp end, String status, Integer number, Integer casinoid, Integer dealerid) {
        super(Games.GAMES);

        set(0, id);
        set(1, start);
        set(2, end);
        set(3, status);
        set(4, number);
        set(5, casinoid);
        set(6, dealerid);
    }
}
