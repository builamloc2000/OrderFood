package com.example.user_service.application.mapper;

import com.example.user_service.application.dto.request.UserCreateRequestDTO;
import com.example.user_service.application.dto.request.UserUpdateRequestDTO;
import com.example.user_service.application.dto.response.UserResponseDTO;
import com.example.user_service.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequestDTO userDTO);
    UserResponseDTO toUserDTO(User user);
    void updateToUser(@MappingTarget User user, UserUpdateRequestDTO userDTO);
    List<UserResponseDTO> toUserDTOs(List<User> users);
}
