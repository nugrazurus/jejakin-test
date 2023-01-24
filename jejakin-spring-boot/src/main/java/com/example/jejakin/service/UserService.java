package com.example.jejakin.service;

import com.example.jejakin.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByEmail(String email);

    User findById(String id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUserById(String id);

}
