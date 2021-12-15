package com.example.dto.exception;

public class InternalServerException extends RuntimeException{
    public InternalServerException(Exception exception){
        super(exception.getMessage());
    }
}
