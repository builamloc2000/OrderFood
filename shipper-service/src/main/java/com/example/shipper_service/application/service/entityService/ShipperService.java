package com.example.shipper_service.application.service.entityService;

import com.example.shipper_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.shipper_service.application.dto.request.ShipperUpdateRequestDTO;
import com.example.shipper_service.application.dto.response.ShipperResponseDTO;
import com.example.shipper_service.domain.Shipper;

import java.util.List;
import java.util.Optional;

public interface ShipperService {
    Shipper saveShipper(ShipperCreateRequestDTO shipper);
    Shipper updateShipper(ShipperUpdateRequestDTO shipper, Long id);
    void deleteShipper(Long id);
    List<ShipperResponseDTO> fetchShipperList();
    ShipperResponseDTO findShipperById(Long id);
}
