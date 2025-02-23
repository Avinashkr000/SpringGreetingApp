package com.example.SpringGreetingApp.service;

import com.example.SpringGreetingApp.model.GreetingEntity;
import com.example.SpringGreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity();
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<GreetingEntity> updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        });
    }
}
