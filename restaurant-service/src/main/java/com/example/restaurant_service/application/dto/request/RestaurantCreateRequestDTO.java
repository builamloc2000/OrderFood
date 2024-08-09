package com.example.restaurant_service.application.dto.request;

public class RestaurantCreateRequestDTO {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
