package com.example.supermarket.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.supermarket.domain.Product;
import com.example.supermarket.domain.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<List<Product>> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getOne(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(int productId) {
        this.getProduct(productId).ifPresent(product -> {
            productRepository.delete(productId);
        });
    }
}
