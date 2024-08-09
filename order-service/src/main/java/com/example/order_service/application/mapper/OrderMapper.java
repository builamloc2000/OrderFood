package com.example.order_service.application.mapper;

import com.example.order_service.application.dto.request.OrderUpdateStatusRequestDTO;
import com.example.order_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.order_service.application.dto.request.UserCreateOrderRequestDTO;
import com.example.order_service.application.dto.response.OrderResponseDTO;
import com.example.order_service.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    void updateStatusToOrder(@MappingTarget Order order, OrderUpdateStatusRequestDTO orderUpdateStatusRequestDTO);
    void updateShipperToOrder(@MappingTarget Order order, ShipperCreateRequestDTO shipperCreateRequestDTO);
    Order saveUserToOrder(UserCreateOrderRequestDTO userCreateOrderRequestDTO);
    OrderResponseDTO toOrderResponseDto(Order order);
    List<OrderResponseDTO> toOrderResponseDtoList(List<Order> orders);
}
