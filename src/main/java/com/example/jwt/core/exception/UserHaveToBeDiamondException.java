package com.example.jwt.core.exception;

public class UserHaveToBeDiamondException extends RuntimeException{

    public UserHaveToBeDiamondException(String errorMessage){
        super(errorMessage);
    }
}
