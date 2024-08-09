package com.example.restaurant_service.application.mapper;

import com.example.restaurant_service.application.dto.request.ResMenuCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.ResMenuUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.MenuResponseDTO;
import com.example.restaurant_service.domain.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    Menu toMenu(ResMenuCreateRequestDTO requestDTO);
    void updateMenu(@MappingTarget Menu menu, ResMenuUpdateRequestDTO requestDTO);
    MenuResponseDTO toMenuResponseDto(Menu menu);
    List<MenuResponseDTO> toMenuResponseDtoList(List<Menu> menuList);
}
