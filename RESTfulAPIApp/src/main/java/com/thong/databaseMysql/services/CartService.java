package com.thong.databaseMysql.services;

import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.domain.entities.OrderEntity;

import java.util.List;
import java.util.Optional;


public interface CartService {

    CartEntity save(CartEntity product);

    List<CartEntity> findAll();

    Optional<CartEntity> findOne(Integer id);

    boolean isExist(Integer id);

    CartEntity updateQuantity(Integer cartId);

}
