package com.example.restaurant_service.application.service.entityService;


import com.example.restaurant_service.application.dto.request.ResMenuCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.ResMenuUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.MenuResponseDTO;
import com.example.restaurant_service.domain.Menu;

import java.util.List;

public interface MenuService {
    List<MenuResponseDTO> fetchMenuList();
    Menu saveMenu(ResMenuCreateRequestDTO requestDTO);
    Menu updateMenu(ResMenuUpdateRequestDTO requestDTO, Long id);
    void deleteMenu(Long id);
    MenuResponseDTO findMenuById(Long id);

}
