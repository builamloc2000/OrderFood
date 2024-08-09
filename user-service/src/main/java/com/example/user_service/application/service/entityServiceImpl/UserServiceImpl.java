package com.example.user_service.application.service.entityServiceImpl;

import com.example.user_service.application.dto.request.UserCreateRequestDTO;
import com.example.user_service.application.dto.request.UserUpdateRequestDTO;
import com.example.user_service.application.dto.response.UserResponseDTO;

import com.example.user_service.application.mapper.UserMapper;
import com.example.user_service.application.service.entityService.UserService;
import com.example.user_service.domain.User;
import com.example.user_service.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User saveUser(UserCreateRequestDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserUpdateRequestDTO userDTO, Long id) {
        User user = userRepository.findById(id).get();
        userMapper.updateToUser(user, userDTO);
        return userRepository.save(user);
    }

    @Override
    public List<UserResponseDTO> fetchUserList() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    @Override
    public UserResponseDTO findUserById(Long id) {
        return userMapper.toUserDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Can not find user")));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
