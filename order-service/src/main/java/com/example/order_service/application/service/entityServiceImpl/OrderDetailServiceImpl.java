package com.example.order_service.application.service.entityServiceImpl;

import com.example.order_service.application.dto.request.UserCreateOrderDetailRequestDTO;
import com.example.order_service.application.dto.response.OrderDetailResponseDTO;
import com.example.order_service.application.mapper.OrderDetailMapper;
import com.example.order_service.application.service.entityService.OrderDetailService;
import com.example.order_service.domain.OrderDetail;
import com.example.order_service.infrastructure.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetailResponseDTO findById(Long id) {

        return orderDetailMapper.toOrderDetailResponseDTO(orderDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find OrderDetail")));
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetailResponseDTO> fetchOrderDetail() {

        return orderDetailMapper.toOrderDetailResponseDtoList(orderDetailRepository.findAll());
    }

    @Override
    public OrderDetail saveOrderDetail(UserCreateOrderDetailRequestDTO userCreateOrderDetailRequestDTO) {
        OrderDetail orderDetail = orderDetailMapper.toOrderDetail(userCreateOrderDetailRequestDTO);
        return orderDetailRepository.save(orderDetail);
    }
}
