package com.example.jwt.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(error -> error.getField(), error -> error.getDefaultMessage())))
                .build();
    }

    @ExceptionHandler(UserNot18Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValid(UserNot18Exception ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(Map.of("err",ex.getMessage()))
                .build();
    }

    @ExceptionHandler(UserHaveToBeDiamondException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValid(UserHaveToBeDiamondException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(Map.of("err",ex.getMessage()))
                .build();
    }

    @ExceptionHandler(CantDeleteAdminException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValid(CantDeleteAdminException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(Map.of("err",ex.getMessage()))
                .build();
    }

    @ExceptionHandler(ProductNotInStockException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValid(ProductNotInStockException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(Map.of("err",ex.getMessage()))
                .build();
    }

}


