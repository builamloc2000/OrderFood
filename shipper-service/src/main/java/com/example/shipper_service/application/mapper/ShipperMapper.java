package com.example.shipper_service.application.mapper;

import com.example.shipper_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.shipper_service.application.dto.request.ShipperUpdateRequestDTO;
import com.example.shipper_service.application.dto.response.ShipperResponseDTO;
import com.example.shipper_service.domain.Shipper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipperMapper {
    Shipper shipperDTOtoShipper(ShipperCreateRequestDTO shipperDTO);
    ShipperResponseDTO shipperTOShipperDTO(Shipper shipper);
    List<ShipperResponseDTO> shippersToShipperDTOs(List<Shipper> shippers);
    void updateShipper(@MappingTarget Shipper shipper, ShipperUpdateRequestDTO shipperDTO);
}
