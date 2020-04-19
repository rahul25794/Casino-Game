/*
 * This file is generated by jOOQ.
 */
package com.casino.jooq.db;


import com.casino.jooq.db.tables.Bets;
import com.casino.jooq.db.tables.Casinos;
import com.casino.jooq.db.tables.Dealers;
import com.casino.jooq.db.tables.Games;
import com.casino.jooq.db.tables.Users;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in casino
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>casino.bets</code>.
     */
    public static final Bets BETS = Bets.BETS;

    /**
     * The table <code>casino.casinos</code>.
     */
    public static final Casinos CASINOS = Casinos.CASINOS;

    /**
     * The table <code>casino.dealers</code>.
     */
    public static final Dealers DEALERS = Dealers.DEALERS;

    /**
     * The table <code>casino.games</code>.
     */
    public static final Games GAMES = Games.GAMES;

    /**
     * The table <code>casino.users</code>.
     */
    public static final Users USERS = Users.USERS;
}
