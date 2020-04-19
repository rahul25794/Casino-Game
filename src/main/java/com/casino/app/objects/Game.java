package com.casino.app.objects;

import java.sql.Timestamp;

public class Game {
    public static enum STATUS {
        OPEN,
        CLOSED
    }
    public Integer id;
    public Timestamp start;
    public Timestamp end;
    public STATUS status;
    public Integer casinoId;
    public Integer dealerId;
    public Integer number;
}