package com.example.dto.exception;

public class SomeTechnicalProblemException extends RuntimeException{
    public SomeTechnicalProblemException(String message){
        super(message);
    }
}
