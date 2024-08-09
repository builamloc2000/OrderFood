package com.example.restaurant_service.application.mapper;

import com.example.restaurant_service.application.dto.request.FoodCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.FoodUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.FoodResponseDTO;
import com.example.restaurant_service.domain.Food;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodResponseDTO toFoodDTO(Food food);
    List<FoodResponseDTO> toFoodDTOs(List<Food> foodList);
    Food toFood(FoodCreateRequestDTO foodCreateRequestDTO);
    void updateFood(@MappingTarget Food food, FoodUpdateRequestDTO foodUpdateRequestDTO);
}
