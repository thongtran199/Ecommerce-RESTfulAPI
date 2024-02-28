package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.domain.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends CrudRepository<CartEntity, Integer> {
}
