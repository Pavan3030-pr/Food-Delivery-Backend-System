package com.prathu.fooddeliverybackendservice.controller;

import com.prathu.fooddeliverybackendservice.dto.MenuItemDto;
import com.prathu.fooddeliverybackendservice.model.MenuItem;
import com.prathu.fooddeliverybackendservice.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/menu-items")
    public String addMenuItem(@RequestBody MenuItemDto dto) {
        return menuItemService.addMenuItem(dto);
    }

    @GetMapping("/restaurants/{restaurantId}/menu-items")
    public List<MenuItem> getMenuItemsByRestaurant(
            @PathVariable Long restaurantId) {

        return menuItemService.getMenuByRestaurant(restaurantId);
    }
}