package com.example.demo_system.controller.advice.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse { 
    private int status;
    private String message;
    
}
