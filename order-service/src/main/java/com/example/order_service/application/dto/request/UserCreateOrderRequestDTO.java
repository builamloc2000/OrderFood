package com.example.order_service.application.dto.request;

import java.util.Date;

public class UserCreateOrderRequestDTO {
    private Long userId;
    private Long restaurantId;
    private Date timeCreate;
    private int statusId;

    public Long getUserId() {
        return userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public int getStatusId() {
        return statusId;
    }
}
