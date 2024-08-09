package com.example.order_service.application.dto.request;

public class UserCreateOrderDetailRequestDTO {
    private Long orderId;
    private Long quantity;
    private Long menuId;

    public Long getQuantity() {
        return quantity;
    }

    public Long getMenuId() {
        return menuId;
    }

    public Long getOrderId() {
        return orderId;
    }
}
