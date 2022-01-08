package com.test.service;

import com.test.model.Order;
import com.test.model.User;
import com.test.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void take(User user) {
        Order order =orderRepository.take(user);
        order.setTakenDate(LocalDateTime.now());
    }
}
