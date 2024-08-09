package com.example.shipper_service.application.service.entiryServiceImpl;

import com.example.shipper_service.application.dto.request.ShipperCreateRequestDTO;
import com.example.shipper_service.application.dto.request.ShipperUpdateRequestDTO;
import com.example.shipper_service.application.dto.response.ShipperResponseDTO;
import com.example.shipper_service.application.mapper.ShipperMapper;
import com.example.shipper_service.application.service.entityService.ShipperService;
import com.example.shipper_service.domain.Shipper;
import com.example.shipper_service.infrastructure.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShipperServiceImpl implements ShipperService {
    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private ShipperMapper shipperMapper;

    @Override
    public Shipper saveShipper(ShipperCreateRequestDTO shipperDTO) {
        Shipper shipper = shipperMapper.shipperDTOtoShipper(shipperDTO);
        return shipperRepository.save(shipper);
    }

    @Override
    public Shipper updateShipper(ShipperUpdateRequestDTO shipperDTO, Long id) {
        Shipper shipper = shipperRepository.findById(id).get();
        shipperMapper.updateShipper(shipper, shipperDTO );
//        Shipper shipperDB = shipperRepository.findById(id).get();
//        if (Objects.nonNull(shipper.getAddress())
//                && !"".equalsIgnoreCase(
//                shipper.getAddress())) {
//            shipperDB.setAddress(
//                    shipper.getAddress());
//        }
//        if (Objects.nonNull(shipper.getFirstName())
//                && !"".equalsIgnoreCase(
//                shipper.getFirstName())) {
//            shipperDB.setFirstName(
//                    shipper.getFirstName());
//        }
//        if (Objects.nonNull(shipper.getLastName())
//                && !"".equalsIgnoreCase(
//                shipper.getLastName())) {
//            shipperDB.setLastName(
//                    shipper.getLastName());
//        }
//

        return shipperRepository.save(shipper);
    }

    @Override
    public void deleteShipper(Long id) {
        shipperRepository.deleteById(id);
    }

    @Override
    public List<ShipperResponseDTO> fetchShipperList() {

        return shipperMapper.shippersToShipperDTOs(shipperRepository.findAll()) ;
    }

    @Override
    public ShipperResponseDTO findShipperById(Long id) {
        return shipperMapper.shipperTOShipperDTO( shipperRepository.findById(id).orElseThrow(()->new RuntimeException("Can not find shipper")));

    }
}
