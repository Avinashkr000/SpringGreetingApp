package com.example.SpringGreetingApp.controller;

import com.example.SpringGreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Generate and save a greeting
    @GetMapping
    public Map<String, String> getGreet(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // Retrieve a greeting by ID
    @GetMapping("/{id}")
    public Map<String, String> getGreetById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // Retrieve all stored greetings
    @GetMapping("/all")
    public List<Map<String, String>> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // Update a greeting message by ID
    @PutMapping("/update/{id}")
    public Map<String, String> updateGreeting(
            @PathVariable Long id,
            @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    // Delete a greeting message by ID
    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id);
    }
}