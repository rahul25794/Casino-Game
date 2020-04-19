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

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>casino</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index BETS_GAME_BET_IDX = Indexes0.BETS_GAME_BET_IDX;
    public static final Index BETS_GAME_USER_IDX = Indexes0.BETS_GAME_USER_IDX;
    public static final Index BETS_ID_UNIQUE = Indexes0.BETS_ID_UNIQUE;
    public static final Index BETS_PRIMARY = Indexes0.BETS_PRIMARY;
    public static final Index CASINOS_ID_UNIQUE = Indexes0.CASINOS_ID_UNIQUE;
    public static final Index CASINOS_PRIMARY = Indexes0.CASINOS_PRIMARY;
    public static final Index DEALERS_CASINO_DEALER_IDX = Indexes0.DEALERS_CASINO_DEALER_IDX;
    public static final Index DEALERS_ID_UNIQUE = Indexes0.DEALERS_ID_UNIQUE;
    public static final Index DEALERS_PRIMARY = Indexes0.DEALERS_PRIMARY;
    public static final Index GAMES_CASINO_IDX = Indexes0.GAMES_CASINO_IDX;
    public static final Index GAMES_DEALER_GAME_IDX = Indexes0.GAMES_DEALER_GAME_IDX;
    public static final Index GAMES_ID_UNIQUE = Indexes0.GAMES_ID_UNIQUE;
    public static final Index GAMES_PRIMARY = Indexes0.GAMES_PRIMARY;
    public static final Index USERS_CASINO_USER_IDX = Indexes0.USERS_CASINO_USER_IDX;
    public static final Index USERS_ID_UNIQUE = Indexes0.USERS_ID_UNIQUE;
    public static final Index USERS_PRIMARY = Indexes0.USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index BETS_GAME_BET_IDX = Internal.createIndex("game-bet_idx", Bets.BETS, new OrderField[] { Bets.BETS.GAMEID }, false);
        public static Index BETS_GAME_USER_IDX = Internal.createIndex("game-user_idx", Bets.BETS, new OrderField[] { Bets.BETS.USERID }, false);
        public static Index BETS_ID_UNIQUE = Internal.createIndex("id_UNIQUE", Bets.BETS, new OrderField[] { Bets.BETS.ID }, true);
        public static Index BETS_PRIMARY = Internal.createIndex("PRIMARY", Bets.BETS, new OrderField[] { Bets.BETS.ID }, true);
        public static Index CASINOS_ID_UNIQUE = Internal.createIndex("Id_UNIQUE", Casinos.CASINOS, new OrderField[] { Casinos.CASINOS.ID }, true);
        public static Index CASINOS_PRIMARY = Internal.createIndex("PRIMARY", Casinos.CASINOS, new OrderField[] { Casinos.CASINOS.ID }, true);
        public static Index DEALERS_CASINO_DEALER_IDX = Internal.createIndex("casino-dealer_idx", Dealers.DEALERS, new OrderField[] { Dealers.DEALERS.CASINOID }, false);
        public static Index DEALERS_ID_UNIQUE = Internal.createIndex("id_UNIQUE", Dealers.DEALERS, new OrderField[] { Dealers.DEALERS.ID }, true);
        public static Index DEALERS_PRIMARY = Internal.createIndex("PRIMARY", Dealers.DEALERS, new OrderField[] { Dealers.DEALERS.ID }, true);
        public static Index GAMES_CASINO_IDX = Internal.createIndex("casino_idx", Games.GAMES, new OrderField[] { Games.GAMES.CASINOID }, false);
        public static Index GAMES_DEALER_GAME_IDX = Internal.createIndex("dealer-game_idx", Games.GAMES, new OrderField[] { Games.GAMES.DEALERID }, false);
        public static Index GAMES_ID_UNIQUE = Internal.createIndex("id_UNIQUE", Games.GAMES, new OrderField[] { Games.GAMES.ID }, true);
        public static Index GAMES_PRIMARY = Internal.createIndex("PRIMARY", Games.GAMES, new OrderField[] { Games.GAMES.ID }, true);
        public static Index USERS_CASINO_USER_IDX = Internal.createIndex("casino-user_idx", Users.USERS, new OrderField[] { Users.USERS.CASINOID }, false);
        public static Index USERS_ID_UNIQUE = Internal.createIndex("id_UNIQUE", Users.USERS, new OrderField[] { Users.USERS.ID }, true);
        public static Index USERS_PRIMARY = Internal.createIndex("PRIMARY", Users.USERS, new OrderField[] { Users.USERS.ID }, true);
    }
}