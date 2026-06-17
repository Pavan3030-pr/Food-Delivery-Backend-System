package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.dto.OrderDto;
import com.prathu.fooddeliverybackendservice.model.Order;
import com.prathu.fooddeliverybackendservice.model.Restaurant;
import com.prathu.fooddeliverybackendservice.repository.OrderRepository;
import com.prathu.fooddeliverybackendservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public String placeOrder(OrderDto dto) {

        Restaurant restaurant =
                restaurantRepository.findById(dto.getRestaurantId())
                        .orElse(null);

        if (restaurant == null) {
            return "Restaurant not found";
        }

        Order order = new Order();

        order.setUserEmail(dto.getUserEmail());
        order.setStatus("PLACED");
        order.setRestaurant(restaurant);

        orderRepository.save(order);

        return "Order Placed Successfully";
    }
}