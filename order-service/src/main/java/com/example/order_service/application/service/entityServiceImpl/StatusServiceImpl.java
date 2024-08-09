package com.example.order_service.application.service.entityServiceImpl;

import com.example.order_service.application.dto.response.StatusResponseDTO;
import com.example.order_service.application.mapper.StatusMapper;
import com.example.order_service.application.service.entityService.StatusService;
import com.example.order_service.infrastructure.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private StatusRepository statusRepository;
    @Override
    public StatusResponseDTO findStatusById(Long id) {
        return statusMapper.toStatusDTO(statusRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find status")));
    }
}
