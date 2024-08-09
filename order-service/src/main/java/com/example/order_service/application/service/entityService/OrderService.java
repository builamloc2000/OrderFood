package com.example.order_service.application.service.entityService;

import com.example.order_service.application.dto.request.OrderUpdateStatusRequestDTO;
import com.example.order_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.order_service.application.dto.request.UserCreateOrderDetailRequestDTO;
import com.example.order_service.application.dto.request.UserCreateOrderRequestDTO;
import com.example.order_service.application.dto.response.OrderResponseDTO;
import com.example.order_service.domain.Order;

import java.util.List;

public interface OrderService {
    Order updateStatusOrder(OrderUpdateStatusRequestDTO orderUpdateStatusRequestDTO, Long id);
    void deleteOrder(Long id);
    Order updateShipper(ShipperCreateRequestDTO shipperCreateRequestDTO, Long id);
    Order saveUserOrder(UserCreateOrderRequestDTO userCreateOrderRequestDTO);
    List<OrderResponseDTO> fetchOrderList();
    OrderResponseDTO findById(Long id);


}
