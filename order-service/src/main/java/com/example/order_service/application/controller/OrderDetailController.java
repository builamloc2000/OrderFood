package com.example.order_service.application.controller;

import com.example.order_service.application.dto.request.UserCreateOrderDetailRequestDTO;
import com.example.order_service.application.dto.response.OrderDetailResponseDTO;
import com.example.order_service.application.service.entityService.OrderDetailService;
import com.example.order_service.domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    //api for user, restaurant
    //they can know price, quantity of each item they buy
    @GetMapping("/orderDetail/{id}")
    public OrderDetailResponseDTO orderDetailResponseDTO(@PathVariable Long id){
        return orderDetailService.findById(id);
    }
    //api for user
    //list all item in 1 order they have bought with detail such as price, quantity
    @GetMapping("/orderDetail")
    public List<OrderDetailResponseDTO> orderDetailResponseDTO(){
        return orderDetailService.fetchOrderDetail();
    }
    //api for user
    //they can delete 1 item in their order, dont need to delete all order because of 1 item order wrong
    @DeleteMapping("/orderDetail/{id}")
    public String orderDetail(@PathVariable Long id){
        orderDetailService.deleteOrderDetail(id);
        return "Deleted successfully";
    }
    //api for user
    //order each item
    @PostMapping("/orderDetail")
    public OrderDetail saveOrderDetail(@RequestBody UserCreateOrderDetailRequestDTO userCreateOrderDetailRequestDTO){
        return orderDetailService.saveOrderDetail(userCreateOrderDetailRequestDTO);
    }
}
