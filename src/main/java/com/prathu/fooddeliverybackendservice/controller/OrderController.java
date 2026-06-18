package com.prathu.fooddeliverybackendservice.controller;

import com.prathu.fooddeliverybackendservice.dto.OrderRequest;
import com.prathu.fooddeliverybackendservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(request);
    }
}