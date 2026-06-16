package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.dto.MenuItemDto;
import com.prathu.fooddeliverybackendservice.model.MenuItem;
import com.prathu.fooddeliverybackendservice.model.Restaurant;
import com.prathu.fooddeliverybackendservice.repository.MenuItemRepository;
import com.prathu.fooddeliverybackendservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public String addMenuItem(MenuItemDto dto) {

        Restaurant restaurant = restaurantRepository
                .findById(dto.getRestaurantId())
                .orElse(null);

        if (restaurant == null) {
            return "Restaurant not found";
        }

        MenuItem item = new MenuItem();

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setRestaurant(restaurant);

        menuItemRepository.save(item);

        return "Menu Item Saved: " + item.getName();
    }

    public List<MenuItem> getMenuByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurant_Id(restaurantId);
    }
}