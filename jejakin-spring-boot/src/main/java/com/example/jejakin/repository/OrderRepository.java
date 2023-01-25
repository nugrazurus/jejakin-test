package com.example.jejakin.repository;

import com.example.jejakin.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);

    @Query("{'id': ?0, userId: ?1}")
    Optional<Order> findOptionalByIdAndUserId(String id, String userId);
}
