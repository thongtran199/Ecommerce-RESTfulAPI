package com.thong.databaseMysql.services.impl;

import com.thong.databaseMysql.domain.entities.ShipmentEntity;
import com.thong.databaseMysql.repositories.ShipmentRepository;
import com.thong.databaseMysql.services.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }


    @Override
    public ShipmentEntity save(ShipmentEntity shipmentEntity) {
        return shipmentRepository.save(shipmentEntity);
    }

    @Override
    public List<ShipmentEntity> findAll() {
        return StreamSupport.stream(
                shipmentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShipmentEntity> findOne(Integer id) {
        return shipmentRepository.findById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return shipmentRepository.existsById(id);
    }
}
