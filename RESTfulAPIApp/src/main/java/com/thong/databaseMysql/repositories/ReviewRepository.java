package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.domain.entities.ReviewEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, Integer> {
    @Query("SELECT r FROM ReviewEntity r WHERE r.productEntity.id = :id")
    List<ReviewEntity> findAllByProductId(@Param("id") Integer id);
}
