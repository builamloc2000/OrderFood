package com.example.restaurant_service.application.controller;


import com.example.restaurant_service.application.dto.request.FoodCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.FoodUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.FoodResponseDTO;
import com.example.restaurant_service.application.service.entityService.FoodService;
import com.example.restaurant_service.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class FoodController {
    @Autowired
    private FoodService foodService;

    //have list of food if system require user select food (maybe need later)
    @GetMapping("/food")
    public List<FoodResponseDTO> fetchAllFood(){
        return foodService.fetchFoodList();

    }
    //get name of 1 food (maybe food can have more detail latter). Now food only have name.
    @GetMapping("/food/{id}")
    public FoodResponseDTO findFoodById(@PathVariable Long id){
        return foodService.findFoodById(id);
    }
    //delete food from system
    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
        return "Deleted successfully";
    }
    //create new food
    @PostMapping("/food")
    public Food saveFood(@RequestBody FoodCreateRequestDTO foodCreateRequestDTO){
        return foodService.saveFood(foodCreateRequestDTO);
    }
    //update name of food
    @PutMapping("/food/{id}")
    public Food updateFood(@RequestBody FoodUpdateRequestDTO foodUpdateRequestDTO,@PathVariable Long id){
        return foodService.updateFood(foodUpdateRequestDTO , id);
    }
}
