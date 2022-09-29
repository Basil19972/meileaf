package com.example.jwt.core.exception;

public class UserNot18Exception extends RuntimeException{

    public UserNot18Exception(String errorMessage){
        super(errorMessage);
    }
}
