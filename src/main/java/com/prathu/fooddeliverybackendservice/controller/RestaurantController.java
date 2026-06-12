package com.prathu.fooddeliverybackendservice.controller;

import com.prathu.fooddeliverybackendservice.dto.RestaurantDTO;
import com.prathu.fooddeliverybackendservice.model.Restaurant;
import com.prathu.fooddeliverybackendservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @PostMapping("/restaurants")
    public String addRestaurant(@RequestBody RestaurantDTO dto){
        return restaurantService.addRestaurant(dto);
    }
    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }
    @PutMapping("/restaurants/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id,
                                       @RequestBody Restaurant updatedRestaurant) {
        return restaurantService.updateRestaurant(id, updatedRestaurant);
    }
    @DeleteMapping("/restaurants/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        return restaurantService.deleteRestaurant(id);
    }
}
