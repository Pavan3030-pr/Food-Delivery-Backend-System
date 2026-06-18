package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.dto.OrderItemRequest;
import com.prathu.fooddeliverybackendservice.dto.OrderRequest;
import com.prathu.fooddeliverybackendservice.model.*;
import com.prathu.fooddeliverybackendservice.repository.MenuItemRepository;
import com.prathu.fooddeliverybackendservice.repository.OrderRepository;
import com.prathu.fooddeliverybackendservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public String placeOrder(OrderRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElse(null);

        if (restaurant == null) {
            return "Restaurant not found";
        }

        Order order = new Order();
        order.setUserEmail(request.getUserEmail());
        order.setRestaurant(restaurant);
        order.setStatus("PLACED");

        List<OrderItem> orderItems = new ArrayList<>();

        double total = 0;

        for (OrderItemRequest itemReq : request.getItems()) {

            MenuItem menuItem = menuItemRepository.findById(itemReq.getMenuItemId())
                    .orElse(null);

            if (menuItem == null) {
                return "Menu item not found: " + itemReq.getMenuItemId();
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(itemReq.getQuantity());

            // 🔥 THIS IS THE MISSING LINE
            orderItem.setOrder(order);

            orderItems.add(orderItem);

            total += menuItem.getPrice() * itemReq.getQuantity();
        }

        order.setOrderItems(orderItems);

        orderRepository.save(order);

        return "Order placed successfully. Total = " + total;
    }
}