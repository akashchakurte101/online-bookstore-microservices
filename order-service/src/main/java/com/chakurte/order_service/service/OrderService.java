package com.chakurte.order_service.service;

import com.chakurte.order_service.dao.OrderRepo;
import com.chakurte.order_service.model.Book;
import com.chakurte.order_service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public Order create(Order order) {
    return orderRepo.save(order);
    }
}
