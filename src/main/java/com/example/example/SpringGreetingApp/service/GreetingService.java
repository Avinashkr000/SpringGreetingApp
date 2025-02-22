package com.example.example.SpringGreetingApp.service;
import com.example.example.SpringGreetingApp.model.Greeting;
import com.example.example.SpringGreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
