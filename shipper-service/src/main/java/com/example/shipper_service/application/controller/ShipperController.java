package com.example.shipper_service.application.controller;

import com.example.shipper_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.shipper_service.application.dto.request.ShipperUpdateRequestDTO;
import com.example.shipper_service.application.dto.response.ShipperResponseDTO;
import com.example.shipper_service.application.service.entityService.ShipperService;
import com.example.shipper_service.domain.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @PostMapping("/addShipper")
    public Shipper saveShipper(@RequestBody ShipperCreateRequestDTO shipperDTO){
        return shipperService.saveShipper(shipperDTO);
    }

    @PutMapping("/shipper/{id}")
    public Shipper updateShipper(@RequestBody ShipperUpdateRequestDTO shipperDTO, @PathVariable("id") Long id){
        return shipperService.updateShipper(shipperDTO, id);
    }

    @DeleteMapping("/shipper/{id}")
    public String deleteShipper(@PathVariable("id") Long id){
        shipperService.deleteShipper(id);
        return "Deleted successfully";
    }

    @GetMapping("/shipper")
    public List<ShipperResponseDTO> fetchShipperList(){
        return shipperService.fetchShipperList();
    }

    @GetMapping("/shipper/{id}")
    public ShipperResponseDTO findShipperById(@PathVariable("id") Long id){
        return shipperService.findShipperById(id);
    }


}
