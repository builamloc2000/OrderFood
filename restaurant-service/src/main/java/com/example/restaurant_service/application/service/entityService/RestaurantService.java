package com.example.restaurant_service.application.service.entityService;



import com.example.restaurant_service.application.dto.request.RestaurantCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.RestaurantUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.RestaurantResponseDTO;
import com.example.restaurant_service.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponseDTO> fetchRestaurantList();
    Restaurant saveRestaurant(RestaurantCreateRequestDTO requestDTO);
    Restaurant updateRestaurant(RestaurantUpdateRequestDTO requestDTO, Long id);
    void deleteRestaurantById(Long id);
    RestaurantResponseDTO findRestaurant(Long id);
}
