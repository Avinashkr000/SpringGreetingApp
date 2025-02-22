package com.example.SpringGreetingApp.service;

import com.example.SpringGreetingApp.model.GreetingEntity;
import com.example.SpringGreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting); // Ensure it returns the saved entity with ID
    }

    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
