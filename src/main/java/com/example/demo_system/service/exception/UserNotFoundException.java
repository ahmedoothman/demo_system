package com.example.demo_system.service.exception;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
