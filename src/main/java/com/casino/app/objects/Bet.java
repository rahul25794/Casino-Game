package com.casino.app.objects;

import java.sql.Timestamp;

public class Bet {
    public static enum STATUS{
        PLACED,
        WON,
        LOST
    };
    public Integer id;
    public Double amount;
    public Timestamp time;
    public Integer userId;
    public Integer gameId;
    public Integer number;
    public STATUS status;
}