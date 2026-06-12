package com.prathu.fooddeliverybackendservice.repository;

import com.prathu.fooddeliverybackendservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
