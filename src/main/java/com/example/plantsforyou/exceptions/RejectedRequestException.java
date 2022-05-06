package com.example.plantsforyou.exceptions;

import org.springframework.http.HttpStatus;


public class RejectedRequestException extends Exception{
    private final HttpStatus status;

    public RejectedRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
