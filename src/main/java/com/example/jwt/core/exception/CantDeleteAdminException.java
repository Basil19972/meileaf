package com.example.jwt.core.exception;

public class CantDeleteAdminException extends RuntimeException{

    public CantDeleteAdminException(String errorMessage){
        super(errorMessage);
    }
}
