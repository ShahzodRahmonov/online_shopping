package com.company.exceptions;

public class OrderFailedException extends RuntimeException{
    public OrderFailedException(String message) {
        super(message);
    }
}
