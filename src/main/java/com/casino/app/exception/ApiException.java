package com.casino.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApiException extends Exception{
    public ApiException(String error){
        super(error);
    }
}