package com.example.demo.exceptions;

public class LowInventoryException extends RuntimeException {

    public LowInventoryException(final String message) {

        super(message);
    }

}