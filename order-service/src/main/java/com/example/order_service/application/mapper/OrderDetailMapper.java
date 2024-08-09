package com.example.order_service.application.mapper;

import com.example.order_service.application.dto.request.UserCreateOrderDetailRequestDTO;
import com.example.order_service.application.dto.response.OrderDetailResponseDTO;
import com.example.order_service.domain.OrderDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailResponseDTO toOrderDetailResponseDTO(OrderDetail orderDetail);
    OrderDetail toOrderDetail(UserCreateOrderDetailRequestDTO userCreateOrderDetailRequestDTO);
    List<OrderDetailResponseDTO> toOrderDetailResponseDtoList(List<OrderDetail> orderDetails);
}
