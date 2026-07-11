package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
        Objects.requireNonNull(id, "id must not be null");
        return productRepository.findById(id);
    }
    
    public Product createProduct(Product product) {
        Objects.requireNonNull(product, "product must not be null");
        return Objects.requireNonNull(productRepository.save(product));
    }
    
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id)
            .map(product -> {
                product.setName(productDetails.getName());
                product.setDescription(productDetails.getDescription());
                product.setPrice(productDetails.getPrice());
                return productRepository.save(product);
            })
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    
    public void deleteProduct(Long id) {
        Objects.requireNonNull(id, "id must not be null");
        productRepository.deleteById(id);
    }
}