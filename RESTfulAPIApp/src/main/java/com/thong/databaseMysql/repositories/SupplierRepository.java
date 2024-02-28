package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.domain.entities.SupplierEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends CrudRepository<SupplierEntity, Integer> {
}
