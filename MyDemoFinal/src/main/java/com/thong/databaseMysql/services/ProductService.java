package com.thong.databaseMysql.services;

import com.thong.databaseMysql.domain.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    ProductEntity save(ProductEntity product);

    List<ProductEntity> findAll();

    Optional<ProductEntity> findOne(Integer id);

    boolean isExist(Integer id);

    List<ProductEntity> findAllByColor(String color);
    List<ProductEntity> findAllByUnitPrice(Float minPrice, Float maxPrice);
    List<ProductEntity> findAllByProductName(String productName);

    Page<ProductEntity> findAllByIsActiveTrue(int page, int size);

}
