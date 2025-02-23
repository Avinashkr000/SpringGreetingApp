package com.example.SpringGreetingApp.exception;

import com.example.SpringGreetingApp.exception.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
