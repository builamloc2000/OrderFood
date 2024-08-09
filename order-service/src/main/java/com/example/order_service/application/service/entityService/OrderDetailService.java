package com.example.order_service.application.service.entityService;

import com.example.order_service.application.dto.request.UserCreateOrderDetailRequestDTO;
import com.example.order_service.application.dto.response.OrderDetailResponseDTO;
import com.example.order_service.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetailResponseDTO findById(Long id);
    void deleteOrderDetail(Long id);
    List<OrderDetailResponseDTO> fetchOrderDetail();
    OrderDetail saveOrderDetail(UserCreateOrderDetailRequestDTO userCreateOrderDetailRequestDTO);
}
