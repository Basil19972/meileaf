package com.example.jwt.core.exception;

public class ProductNotInStockException extends RuntimeException{

    public ProductNotInStockException(String errorMessage){
        super(errorMessage);
    }
}
