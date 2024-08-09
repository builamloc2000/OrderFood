package com.example.restaurant_service.application.mapper;

import com.example.restaurant_service.application.dto.request.RestaurantCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.RestaurantUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.RestaurantResponseDTO;
import com.example.restaurant_service.domain.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantResponseDTO toRestaurantDTO(Restaurant restaurant);
    List<RestaurantResponseDTO> toRestaurantDTOS(List<Restaurant> restaurants);
    Restaurant toRestaurant(RestaurantCreateRequestDTO requestDTO);
    void updateRestaurant(@MappingTarget Restaurant restaurant, RestaurantUpdateRequestDTO requestDTO);
}
