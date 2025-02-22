package com.example.SpringGreetingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.SpringGreetingApp")
public class SpringGreetingApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringGreetingApp.class, args);
	}
}