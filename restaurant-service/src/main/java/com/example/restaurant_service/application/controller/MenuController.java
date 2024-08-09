package com.example.restaurant_service.application.controller;


import com.example.restaurant_service.application.dto.request.ResMenuCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.ResMenuUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.MenuResponseDTO;
import com.example.restaurant_service.application.service.entityService.MenuService;
import com.example.restaurant_service.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MenuController {
    @Autowired
    private MenuService menuService;
    //get list of menu for user
    //they can select food or decide where is cheaper or near them before select restaurant
    @GetMapping("/menu")
    public List<MenuResponseDTO> fetchMenuList(){
        return menuService.fetchMenuList();
    };
    //api for restaurant
    //they can create new food in menu with their price and description
    //note: restaurant can have same food but different price and description
    @PostMapping("/menu")
    public Menu saveMenu(@RequestBody ResMenuCreateRequestDTO requestDTO){
        return menuService.saveMenu(requestDTO);
    };
    //api for restaurant
    //they can update their price and description in menu
    @PutMapping("/menu/{id}")
    public Menu updateMenu(@RequestBody ResMenuUpdateRequestDTO requestDTO, @PathVariable Long id){
        return menuService.updateMenu(requestDTO, id);
    };
    //api for restaurant
    //they can remove food from their menu
    @DeleteMapping("/menu/{id}")
    public String deleteMenu(@PathVariable Long id){
        menuService.deleteMenu(id);
        return "Deleted successfully";
    };
    //api for user, restaurant
    //they can know specific food(price, description) in restaurant
    @GetMapping("/menu/{id}")
    public MenuResponseDTO findMenuById(@PathVariable Long id){
        return menuService.findMenuById(id);
    };

}
