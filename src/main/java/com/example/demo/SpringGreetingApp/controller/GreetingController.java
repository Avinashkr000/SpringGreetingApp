package com.example.demo.SpringGreetingApp.controller;
import com.example.demo.SpringGreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }

    @PostMapping
    public String postGreeting() {
        return greetingService.getGreetingMessage();
    }

    @PutMapping
    public String putGreeting() {
        return greetingService.getGreetingMessage();
    }

    @DeleteMapping
    public String deleteGreeting() {
        return greetingService.getGreetingMessage();
    }
}
