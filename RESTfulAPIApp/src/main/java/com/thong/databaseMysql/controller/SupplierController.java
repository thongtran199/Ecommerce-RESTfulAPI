package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.SupplierDto;
import com.thong.databaseMysql.domain.entities.SupplierEntity;
import com.thong.databaseMysql.mappers.impl.SupplierMapper;
import com.thong.databaseMysql.services.SupplierService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class SupplierController {

    private SupplierService supplierService;
    private SupplierMapper supplierMapper;

    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }

    @PostMapping(path = "/supplier")
    public ResponseEntity<SupplierDto> postMapping(@RequestBody final SupplierDto supplierDto) {
        SupplierEntity entity = supplierMapper.mapFrom(supplierDto);
        SupplierEntity savedEntity = supplierService.save(entity);
        return new ResponseEntity<>(supplierMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "/supplier/{id}")
    public ResponseEntity<SupplierDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody SupplierDto supplierDto) {
        supplierDto.setId(id);
        SupplierEntity entity = supplierMapper.mapFrom(supplierDto);
        SupplierEntity savedEntity = supplierService.save(entity);
        return new ResponseEntity<>(supplierMapper.mapTo(savedEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/supplier")
    public List<SupplierDto> getMapping() {
        List<SupplierEntity> suppliers = supplierService.findAll();
        return suppliers.stream()
                .map(entity -> supplierMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/supplier/{id}")
    public ResponseEntity<SupplierDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<SupplierEntity> foundSupplier = supplierService.findOne(id);
        return foundSupplier.map(entity -> {
                    SupplierDto supplierDto = supplierMapper.mapTo(entity);
                    return new ResponseEntity<>(supplierDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
