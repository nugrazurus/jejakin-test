package com.example.jejakin.repository;

import com.example.jejakin.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findOptionalByEmail(String email);

}
