package com.example.restaurant_service.application.dto.request;

public class ResMenuUpdateRequestDTO {
    private Long restaurantId;
    private Long foodId;
    private float price;
    private String description;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
