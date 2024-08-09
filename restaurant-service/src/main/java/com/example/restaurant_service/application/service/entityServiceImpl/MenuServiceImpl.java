package com.example.restaurant_service.application.service.entityServiceImpl;


import com.example.restaurant_service.application.dto.request.ResMenuCreateRequestDTO;
import com.example.restaurant_service.application.dto.request.ResMenuUpdateRequestDTO;
import com.example.restaurant_service.application.dto.response.MenuResponseDTO;
import com.example.restaurant_service.application.mapper.MenuMapper;
import com.example.restaurant_service.application.service.entityService.MenuService;
import com.example.restaurant_service.domain.Menu;
import com.example.restaurant_service.infrastructure.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public Menu saveMenu(ResMenuCreateRequestDTO requestDTO) {
        Menu menu = menuMapper.toMenu(requestDTO);
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(ResMenuUpdateRequestDTO requestDTO, Long id) {
        Menu menu = menuRepository.findById(id).get();
        menuMapper.updateMenu(menu, requestDTO);
        return menuRepository.save(menu);
    }

    @Override
    public List<MenuResponseDTO> fetchMenuList() {
        return menuMapper.toMenuResponseDtoList(menuRepository.findAll());
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public MenuResponseDTO findMenuById(Long id) {
        return menuMapper.toMenuResponseDto(menuRepository.findById(id).orElseThrow(() -> new RuntimeException("cannot get menu")));
    }




}
