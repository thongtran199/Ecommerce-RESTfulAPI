package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    @Query("SELECT p FROM ProductEntity p WHERE p.color LIKE %:color%")
    List<ProductEntity> findAllByColor(@Param("color") String color);
    @Query("SELECT p FROM ProductEntity p WHERE p.unitPrice >= :minPrice AND p.unitPrice <= :maxPrice")
    List<ProductEntity> findAllByUnitPrice(Float minPrice, Float maxPrice);
    @Query("SELECT p FROM ProductEntity p WHERE p.productName LIKE %:productName%")
    List<ProductEntity> findAllByProductName(@Param("productName") String productName);

    Page<ProductEntity> findAllByIsActiveTrue(Pageable pageable);
}
