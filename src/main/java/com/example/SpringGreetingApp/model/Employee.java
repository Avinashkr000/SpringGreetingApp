package com.example.SpringGreetingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull // Lombok annotation to require a value in the constructor
    private String name;

    @Column(nullable = false)
    @NonNull
    private String role;

    @Column(nullable = false)
    @NonNull
    private double salary;

    @Column(nullable = false)
    @NonNull
    private String department;
}
