package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.domain.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {
    @Query("SELECT o FROM OrderDetailsEntity o WHERE o.orderEntity.id = :id")
    List<OrderDetailsEntity> findAllByOrderId(Integer id);
}
