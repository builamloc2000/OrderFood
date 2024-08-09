package com.example.restaurant_service.application.service.entityService;



import com.example.restaurant_service.application.dto.request.FoodCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.FoodUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.FoodResponseDTO;
import com.example.restaurant_service.domain.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Food saveFood(FoodCreateRequestDTO foodDTO);
    Food updateFood(FoodUpdateRequestDTO foodDTO, Long foodId);
    void deleteFood(Long foodId);
    List<FoodResponseDTO> fetchFoodList();
    FoodResponseDTO findFoodById(Long id);
}
