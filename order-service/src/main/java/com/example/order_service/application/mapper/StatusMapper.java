package com.example.order_service.application.mapper;

import com.example.order_service.application.dto.response.StatusResponseDTO;
import com.example.order_service.domain.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusResponseDTO toStatusDTO(Status status);
}
