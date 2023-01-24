package com.example.jejakin.controller;

import com.example.jejakin.model.User;
import com.example.jejakin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(userService.findByEmail(email));
    }

    @PostMapping(value = "")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        if (ObjectUtils.isEmpty(user)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is empty");
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return HttpStatus.OK;
    }

}
