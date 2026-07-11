package com.example.demo.config;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Create some sample products
        productRepository.save(new Product("Laptop", "High-performance laptop", 999.99));
        productRepository.save(new Product("Smartphone", "Latest smartphone model", 699.99));
        productRepository.save(new Product("Headphones", "Noise-cancelling headphones", 199.99));
        
        System.out.println("Sample data initialized");
    }
}