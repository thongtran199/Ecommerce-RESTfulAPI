package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CartDetailsEntity;
import com.thong.databaseMysql.domain.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartDetailsRepository extends CrudRepository<CartDetailsEntity, Integer> {
}
