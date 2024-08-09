package com.example.order_service.application.service.entityService;

import com.example.order_service.application.dto.response.StatusResponseDTO;

import java.util.List;

public interface StatusService {
    StatusResponseDTO findStatusById(Long id);

}
