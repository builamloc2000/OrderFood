package com.example.restaurant_service.application.service.entityServiceImpl;


import com.example.restaurant_service.application.dto.request.FoodCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.FoodUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.FoodResponseDTO;
import com.example.restaurant_service.application.mapper.FoodMapper;
import com.example.restaurant_service.application.service.entityService.FoodService;
import com.example.restaurant_service.domain.Food;
import com.example.restaurant_service.infrastructure.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Food saveFood(FoodCreateRequestDTO foodDTO) {
        Food food = foodMapper.toFood(foodDTO);
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(FoodUpdateRequestDTO foodDTO, Long foodId) {
        Food food = foodRepository.findById(foodId).get();
        foodMapper.updateFood(food, foodDTO);
        return foodRepository.save(food);
    }

    @Override
    public List<FoodResponseDTO> fetchFoodList() {
        return foodMapper.toFoodDTOs(foodRepository.findAll());
    }

    @Override
    public FoodResponseDTO findFoodById(Long id) {
        return foodMapper.toFoodDTO(foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find food")));
    }

    @Override
    public void deleteFood(Long foodId) {
        foodRepository.deleteById(foodId);
    }
}
