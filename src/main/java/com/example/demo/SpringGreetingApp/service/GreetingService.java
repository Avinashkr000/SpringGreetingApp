package com.example.demo.SpringGreetingApp.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return String.format("{\"message\": \"Hello, %s %s!\"}", firstName, lastName);
        } else if (firstName != null) {
            return String.format("{\"message\": \"Hello, %s!\"}", firstName);
        } else if (lastName != null) {
            return String.format("{\"message\": \"Hello, %s!\"}", lastName);
        } else {
            return "{\"message\": \"Hello, World!\"}";
        }
    }
}
