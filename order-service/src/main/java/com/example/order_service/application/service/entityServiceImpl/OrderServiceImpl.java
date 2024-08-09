package com.example.order_service.application.service.entityServiceImpl;

import com.example.order_service.application.dto.request.OrderUpdateStatusRequestDTO;
import com.example.order_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.order_service.application.dto.request.UserCreateOrderDetailRequestDTO;
import com.example.order_service.application.dto.request.UserCreateOrderRequestDTO;
import com.example.order_service.application.dto.response.OrderResponseDTO;
import com.example.order_service.application.mapper.OrderMapper;
import com.example.order_service.application.service.entityService.OrderService;
import com.example.order_service.domain.Order;
import com.example.order_service.infrastructure.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order updateStatusOrder(OrderUpdateStatusRequestDTO orderUpdateStatusRequestDTO, Long id) {
        Order order = orderRepository.findById(id).get();
        orderMapper.updateStatusToOrder(order, orderUpdateStatusRequestDTO);

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateShipper(ShipperCreateRequestDTO shipperCreateRequestDTO, Long id) {

        Order order =  orderRepository.findById(id).get();
        orderMapper.updateShipperToOrder(order, shipperCreateRequestDTO);
        return orderRepository.save(order);
    }

    @Override
    public Order saveUserOrder(UserCreateOrderRequestDTO UserCreateOrderRequestDTO) {
        Order order = orderMapper.saveUserToOrder(UserCreateOrderRequestDTO);
        return orderRepository.save(order);
    }

    @Override
    public List<OrderResponseDTO> fetchOrderList() {
        return orderMapper.toOrderResponseDtoList(orderRepository.findAll());
    }

    @Override
    public OrderResponseDTO findById(Long id) {
        return orderMapper.toOrderResponseDto(orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Order")));
    }
}
