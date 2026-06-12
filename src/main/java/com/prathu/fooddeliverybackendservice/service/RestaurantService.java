package com.prathu.fooddeliverybackendservice.service;

import com.prathu.fooddeliverybackendservice.dto.RestaurantDTO;
import com.prathu.fooddeliverybackendservice.model.Restaurant;
import com.prathu.fooddeliverybackendservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // CREATE (ONLY CHANGE)
    public String addRestaurant( RestaurantDTO dto) {

        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setRating(dto.getRating());

        restaurantRepository.save(restaurant);

        return "Restaurant saved: " + restaurant.getName();
    }


    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }


    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }


    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {

        Restaurant existing = restaurantRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(updatedRestaurant.getName());
            existing.setAddress(updatedRestaurant.getAddress());
            existing.setRating(updatedRestaurant.getRating());

            return restaurantRepository.save(existing);
        }

        return null;
    }


    public String deleteRestaurant(Long id) {

        Restaurant existing = restaurantRepository.findById(id).orElse(null);

        if (existing != null) {
            restaurantRepository.deleteById(id);
            return "Restaurant deleted successfully";
        }

        return "Restaurant not found";
    }
}