package com.chakurte.order_service.controller;

import com.chakurte.order_service.OrderServiceApplication;
import com.chakurte.order_service.feign.BookClient;
import com.chakurte.order_service.model.Book;
import com.chakurte.order_service.model.Order;
import com.chakurte.order_service.response.OrderResponse;
import com.chakurte.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService serviceApplication;

     @Autowired
     BookClient bookClient;

//    @GetMapping
//    public void get(){
//        System.out.println("inside");
//    }

    @PostMapping
    public OrderResponse create(@RequestBody Order order){
        Book book=bookClient.getBookById(order.getBookId());
        if(book!=null)
        {
            Order savedOrder= serviceApplication.create(order);

            OrderResponse orderResponse=new OrderResponse(
                    savedOrder.getUserId(),
                    savedOrder.getBookId(),
                    savedOrder.getQuantity(),
                    book);
            return orderResponse;
        }
        else{
            return null;
        }
    }

}
