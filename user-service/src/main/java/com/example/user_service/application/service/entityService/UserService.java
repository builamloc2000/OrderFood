package com.example.user_service.application.service.entityService;

import com.example.user_service.application.dto.request.UserCreateRequestDTO;
import com.example.user_service.application.dto.request.UserUpdateRequestDTO;
import com.example.user_service.application.dto.response.UserResponseDTO;
import com.example.user_service.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(UserCreateRequestDTO userDTO);
    User updateUser(UserUpdateRequestDTO userDTO, Long id);
    List<UserResponseDTO> fetchUserList();
    UserResponseDTO findUserById(Long id);
    void deleteUser(Long id);

}
