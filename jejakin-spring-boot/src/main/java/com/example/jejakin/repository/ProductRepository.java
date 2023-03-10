package com.example.jejakin.repository;

import com.example.jejakin.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{'name': {$regex: '.*?0.*', $options: 'i'}}")
    List<Product> findByName(String name);
}
