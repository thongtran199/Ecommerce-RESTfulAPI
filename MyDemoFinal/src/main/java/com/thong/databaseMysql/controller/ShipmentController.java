package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.ShipmentDto;
import com.thong.databaseMysql.domain.entities.ShipmentEntity;
import com.thong.databaseMysql.mappers.impl.ShipmentMapper;
import com.thong.databaseMysql.services.ShipmentService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class ShipmentController {

    private ShipmentService shipmentService;
    private ShipmentMapper shipmentMapper;

    public ShipmentController(ShipmentService shipmentService, ShipmentMapper shipmentMapper) {
        this.shipmentService = shipmentService;
        this.shipmentMapper = shipmentMapper;
    }

    @PostMapping(path = "/shipment")
    public ResponseEntity<ShipmentDto> postMapping(@RequestBody final ShipmentDto shipmentDto) {
        ShipmentEntity product = shipmentMapper.mapFrom(shipmentDto);
        ShipmentEntity savedProduct = shipmentService.save(product);
        return new ResponseEntity<>(shipmentMapper.mapTo(savedProduct), HttpStatus.CREATED);
    }

    @PutMapping(path = "/shipment/{id}")
    public ResponseEntity<ShipmentDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody ShipmentDto shipmentDto) {
        shipmentDto.setId(id);
        ShipmentEntity product = shipmentMapper.mapFrom(shipmentDto);
        ShipmentEntity savedProduct = shipmentService.save(product);
        return new ResponseEntity<>(shipmentMapper.mapTo(savedProduct), HttpStatus.CREATED);
    }

    @GetMapping(path = "/shipment")
    public List<ShipmentDto> getMapping() {
        List<ShipmentEntity> products = shipmentService.findAll();
        return products.stream()
                .map(entity -> shipmentMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/shipment/{id}")
    public ResponseEntity<ShipmentDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<ShipmentEntity> foundProduct = shipmentService.findOne(id);
        return foundProduct.map(entity -> {
                    ShipmentDto shipmentDto = shipmentMapper.mapTo(entity);
                    return new ResponseEntity<>(shipmentDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
