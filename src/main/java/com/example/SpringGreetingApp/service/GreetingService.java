package com.example.SpringGreetingApp.service;
import com.example.SpringGreetingApp.model.GreetingEntity;
import com.example.SpringGreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Generate a greeting, save it to the database, and return it
    public Map<String, String> getPersonalizedGreeting(String firstName, String lastName) {
        Map<String, String> response = new HashMap<>();
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        // Save message to database
        GreetingEntity greetingEntity = new GreetingEntity(message);
        GreetingEntity savedGreeting = greetingRepository.save(greetingEntity);

        response.put("id", String.valueOf(savedGreeting.getId())); // Return the saved ID
        response.put("message", message);
        return response;
    }

    // Retrieve a saved greeting by ID
    public Map<String, String> getGreetingById(Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);

        if (greeting.isPresent()) {
            response.put("id", String.valueOf(greeting.get().getId()));
            response.put("message", greeting.get().getMessage());
        } else {
            response.put("error", "Greeting not found!");
        }

        return response;
    }

    // Retrieve all stored greetings
    public List<Map<String, String>> getAllGreetings() {
        List<GreetingEntity> greetings = greetingRepository.findAll();
        List<Map<String, String>> response = new ArrayList<>();

        for (GreetingEntity greeting : greetings) {
            Map<String, String> greetingMap = new HashMap<>();
            greetingMap.put("id", String.valueOf(greeting.getId()));
            greetingMap.put("message", greeting.getMessage());
            response.add(greetingMap);
        }

        return response;
    }

    // Update an existing greeting message
    public Map<String, String> updateGreeting(Long id, String newMessage) {
        Map<String, String> response = new HashMap<>();
        Optional<GreetingEntity> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            GreetingEntity greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            greetingRepository.save(greeting);

            response.put("id", String.valueOf(greeting.getId()));
            response.put("message", greeting.getMessage());
        } else {
            response.put("error", "Greeting not found!");
        }

        return response;
    }

    // Delete a greeting message by ID
    public Map<String, String> deleteGreeting(Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<GreetingEntity> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            greetingRepository.deleteById(id);
            response.put("message", "Greeting deleted successfully!");
        } else {
            response.put("error", "Greeting not found!");
        }

        return response;
    }
}