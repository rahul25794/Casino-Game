package com.casino.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ServerException extends Exception{
    public ServerException(){
        super("Something went wrong. Please try again.");
    }
}