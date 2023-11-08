package com.thong.databaseMysql.services;

import com.thong.databaseMysql.domain.entities.ProductEntity;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    ProductEntity save(ProductEntity product);

    List<ProductEntity> findAll();

    Optional<ProductEntity> findOne(Integer id);

    boolean isExist(Integer id);


}
