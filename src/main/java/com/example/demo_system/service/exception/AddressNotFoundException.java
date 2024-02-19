package com.example.demo_system.service.exception;

public class AddressNotFoundException  extends RuntimeException{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
