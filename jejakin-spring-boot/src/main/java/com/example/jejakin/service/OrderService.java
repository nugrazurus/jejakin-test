package com.example.jejakin.service;

import com.example.jejakin.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findOrderByUserId(String userId);

    Order createOrder(Order order);

    Optional<Order> findOrderById(String id);

    Order updateOrderAmountById(Order order);

    void deleteOrderByIdAndUserId(String id, String userId);
}
