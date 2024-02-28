package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}
