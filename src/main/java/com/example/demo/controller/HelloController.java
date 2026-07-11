package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
    
    @GetMapping("/greet")
    public Greeting greet() {
        return new Greeting("Hello", "Welcome to Spring Boot Demo");
    }
    
    static class Greeting {
        private String title;
        private String message;
        
        public Greeting(String title, String message) {
            this.title = title;
            this.message = message;
        }
        
        public String getTitle() {
            return title;
        }
        
        public String getMessage() {
            return message;
        }
    }
}