package com.example.user_service.application.controller;


import com.example.user_service.application.dto.request.UserCreateRequestDTO;
import com.example.user_service.application.dto.request.UserUpdateRequestDTO;
import com.example.user_service.application.dto.response.UserResponseDTO;
import com.example.user_service.application.service.entityService.UserService;
import com.example.user_service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody UserCreateRequestDTO userDTO){
        return userService.saveUser(userDTO);
    };

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody UserUpdateRequestDTO userDTO, @PathVariable Long id){
        return userService.updateUser(userDTO, id);
    };

    @GetMapping("/user")
    public List<UserResponseDTO> fetchUserList(){
        return userService.fetchUserList();
    };

    @GetMapping("/user/{id}")
    public UserResponseDTO findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    };

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "Deleted successfully";
    };

}
