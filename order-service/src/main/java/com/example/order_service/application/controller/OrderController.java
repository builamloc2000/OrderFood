package com.example.order_service.application.controller;

import com.example.order_service.application.dto.request.OrderUpdateStatusRequestDTO;
import com.example.order_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.order_service.application.dto.request.UserCreateOrderRequestDTO;
import com.example.order_service.application.dto.response.OrderResponseDTO;
import com.example.order_service.application.service.entityService.OrderService;
import com.example.order_service.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    //api for restaurant and shipper
    //update status of order
    //when they receive order they click UPDATE STATUS to send back status of order for users track their order
    @PutMapping("/order/status/{id}")
    public Order updateStatusOrder(@RequestBody OrderUpdateStatusRequestDTO orderUpdateStatusRequestDTO, @PathVariable Long id){
        return orderService.updateStatusOrder(orderUpdateStatusRequestDTO, id);
    }
    //api for user
    //delete order
    //when user decide to cancel their order
    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "Deleted successfully";
    }
    //api for shipper get food from restaurant
    //update shipper in order
    //when shipper get food, they will have responsibility to bring food to you
    @PutMapping("/order/shipper/{id}")
    public Order updateShipper(@RequestBody ShipperCreateRequestDTO shipperCreateRequestDTO, @PathVariable Long id){
        return  orderService.updateShipper(shipperCreateRequestDTO,id);
    }
    //api for user
    //user create order include timeCreate, restaurant they choose
    @PostMapping("/order")
    public Order saveUserOrder(@RequestBody UserCreateOrderRequestDTO userCreateOrderRequestDTO){
        return orderService.saveUserOrder(userCreateOrderRequestDTO);
    }
    //api for restaurant and shipper
    //they will know list of order from many user
    //MORE FEATURE: retrieve by userID, restaurantID, shipperID -> they can know about their work history
    @GetMapping("/order")
    public List<OrderResponseDTO> fetchOrderList(){
        return orderService.fetchOrderList();
    }
    //api for user
    //they can get their order
    @GetMapping("/order/{id}")
    public OrderResponseDTO findById(@PathVariable Long id){
        return orderService.findById(id);
    }
}
