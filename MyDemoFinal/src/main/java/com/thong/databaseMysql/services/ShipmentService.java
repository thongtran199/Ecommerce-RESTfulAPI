package com.thong.databaseMysql.services;

import com.thong.databaseMysql.domain.entities.ShipmentEntity;

import java.util.List;
import java.util.Optional;


public interface ShipmentService {

    ShipmentEntity save(ShipmentEntity product);

    List<ShipmentEntity> findAll();

    Optional<ShipmentEntity> findOne(Integer id);

    boolean isExist(Integer id);


}
