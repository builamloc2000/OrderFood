package com.example.restaurant_service.application.service.entityServiceImpl;


import com.example.restaurant_service.application.dto.request.RestaurantCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.RestaurantUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.RestaurantResponseDTO;
import com.example.restaurant_service.application.mapper.RestaurantMapper;
import com.example.restaurant_service.application.service.entityService.RestaurantService;
import com.example.restaurant_service.domain.Restaurant;
import com.example.restaurant_service.infrastructure.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;

    //API for list of restaurant
    @Override
    public List<RestaurantResponseDTO> fetchRestaurantList() {
        return restaurantMapper.toRestaurantDTOS(restaurantRepository.findAll());
    }

    @Override
    public Restaurant saveRestaurant(RestaurantCreateRequestDTO requestDTO) {
        Restaurant restaurant = restaurantMapper.toRestaurant(requestDTO);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(RestaurantUpdateRequestDTO requestDTO, Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();
        restaurantMapper.updateRestaurant(restaurant, requestDTO);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantResponseDTO findRestaurant(Long id) {
        return restaurantMapper.toRestaurantDTO(restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("cannot find restaurant")));
    }


}
