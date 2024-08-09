package com.example.restaurant_service.application.controller;


import com.example.restaurant_service.application.dto.request.RestaurantCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.RestaurantUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.RestaurantResponseDTO;
import com.example.restaurant_service.application.service.entityService.RestaurantService;
import com.example.restaurant_service.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    //get list of restaurant for user to choose only have name, address
    @GetMapping("/res")
    public List<RestaurantResponseDTO> fetchRestaurantList(){
        return restaurantService.fetchRestaurantList();
    };
    //create new restaurant(name, address, phoneNumber, email)
    @PostMapping("/res")
    public Restaurant saveRestaurant(@RequestBody RestaurantCreateRequestDTO requestDTO){
        return restaurantService.saveRestaurant(requestDTO);
    };
    //update restaurant(name, address, phoneNumber, email)
    @PutMapping("/res/{id}")
    public Restaurant updateRestaurant(@RequestBody RestaurantUpdateRequestDTO requestDTO, @PathVariable Long id){
        return restaurantService.updateRestaurant(requestDTO, id);
    };
    //delete restaurant from system
    @DeleteMapping("/res/{id}")
    public String deleteRestaurantById(@PathVariable Long id){
        restaurantService.deleteRestaurantById(id);
        return "Deleted successfully";
    };
    //get specific restaurant(name, address)
    @GetMapping("/res/{id}")
    public RestaurantResponseDTO findRestaurant(@PathVariable Long id){
        return restaurantService.findRestaurant(id);
    };

    }

