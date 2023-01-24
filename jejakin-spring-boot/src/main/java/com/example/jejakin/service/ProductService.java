package com.example.jejakin.service;

import com.example.jejakin.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    List<Product> findByName(String name);

    Product findById(String id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(String id);
}
