package com.example.jejakin.controller;

import com.example.jejakin.model.Order;
import com.example.jejakin.service.OrderService;
import com.example.jejakin.service.ProductService;
import com.example.jejakin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable String userId) {
        return ResponseEntity.ok().body(orderService.findOrderByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok().body(orderService.findOrderById(id));
    }

    @PostMapping("")
    public ResponseEntity<Order> createOrder(@Validated @RequestBody Order order) {
        productService.findById(order.getProductId());
        userService.findById(order.getUserId());
        return ResponseEntity.ok().body(orderService.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrderAmount(@PathVariable String id, @RequestBody Order order) {
        order.setId(id);
        return ResponseEntity.ok().body(orderService.updateOrderAmountById(order));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProduct(@PathVariable String id) {
        orderService.deleteOrderById(id);
        return HttpStatus.OK;
    }

}
