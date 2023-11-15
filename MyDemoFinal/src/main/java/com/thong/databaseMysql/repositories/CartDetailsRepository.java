package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CartDetailsEntity;
import com.thong.databaseMysql.domain.entities.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartDetailsRepository extends CrudRepository<CartDetailsEntity, Integer> {
    @Query("SELECT c From CartDetailsEntity c WHERE c.cartEntity.id = :id ")
    List<CartDetailsEntity> findAllByCartId(@Param("id") Integer cartId);
}
