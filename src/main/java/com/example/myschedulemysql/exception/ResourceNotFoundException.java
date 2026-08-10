package com.example.myschedulemysql.exception;

public class ResourceNotFoundException extends   RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
