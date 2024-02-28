package com.thong.databaseMysql.services;

import com.thong.databaseMysql.domain.entities.OrderEntity;
import com.thong.databaseMysql.domain.entities.PaymentEntity;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    OrderEntity save(OrderEntity order);

    List<OrderEntity> findAll();

    Optional<OrderEntity> findOne(Integer id);

    boolean isExist(Integer id);

    OrderEntity updateTotal(Integer orderId);

}
