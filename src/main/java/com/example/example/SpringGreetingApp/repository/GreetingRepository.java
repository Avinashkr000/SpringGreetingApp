package com.example.example.SpringGreetingApp.repository;
import com.example.example.SpringGreetingApp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
