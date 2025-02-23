package com.example.SpringGreetingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SpringGreetingApp.model.GreetingEntity;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
