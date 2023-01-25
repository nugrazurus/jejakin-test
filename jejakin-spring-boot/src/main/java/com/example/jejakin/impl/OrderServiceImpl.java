package com.example.jejakin.impl;

import com.example.jejakin.model.Order;
import com.example.jejakin.repository.OrderRepository;
import com.example.jejakin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findOrderByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrderAmountById(Order order) {
        Optional<Order> orderDb = orderRepository.findById(order.getId());
        if (orderDb.isPresent()) {
            Order orderUpdate = orderDb.get();
            orderUpdate.setAmount(order.getAmount());
            orderRepository.save(orderUpdate);
            return orderUpdate;
        } else {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteOrderByIdAndUserId(String id, String userId) {
        Optional<Order> orderDB = orderRepository.findOptionalByIdAndUserId(id, userId);
        if (orderDB.isPresent()) {
            orderRepository.delete(orderDB.get());
        } else {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }
}
