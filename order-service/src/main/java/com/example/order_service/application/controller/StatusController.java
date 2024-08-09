package com.example.order_service.application.controller;

import com.example.order_service.application.dto.response.StatusResponseDTO;
import com.example.order_service.application.service.entityService.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @Autowired
    private StatusService statusService;
    //for system
    //get name of status to set name in statusID of table.order
    @GetMapping("/status/{id}")
    public StatusResponseDTO findStatusById(@PathVariable Long id){
        return statusService.findStatusById(id);
    }

}
