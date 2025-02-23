package com.example.SpringGreetingApp.controller;

import com.example.SpringGreetingApp.model.GreetingEntity;
import com.example.SpringGreetingApp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/greeting")  // Changed from "/greeting" to "/api/greeting"
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public ResponseEntity<GreetingEntity> createGreeting(@RequestParam String message) {
        GreetingEntity savedGreeting = greetingService.saveGreeting(message);
        return ResponseEntity.ok(savedGreeting);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GreetingEntity> getGreetingById(@PathVariable Long id) {
        Optional<GreetingEntity> greeting = greetingService.getGreetingById(id);
        return greeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<GreetingEntity>> getAllGreetings() {
        List<GreetingEntity> greetings = greetingService.getAllGreetings();
        return ResponseEntity.ok(greetings);
    }

}
