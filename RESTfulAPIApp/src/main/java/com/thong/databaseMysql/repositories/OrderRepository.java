package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.domain.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
