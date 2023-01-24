package com.example.jejakin.impl;

import com.example.jejakin.model.Product;
import com.example.jejakin.repository.ProductRepository;
import com.example.jejakin.service.ProductService;
import com.mongodb.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product createProduct(@NonNull Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        return product.get();
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = productRepository.findById(product.getId());
        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setName(product.getName());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
