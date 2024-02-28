package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.SupplierDto;
import com.thong.databaseMysql.domain.entities.SupplierEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper implements Mapper<SupplierEntity, SupplierDto> {
    private ModelMapper modelMapper;
    public SupplierMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public SupplierDto mapTo(SupplierEntity SupplierEntity) {
        return modelMapper.map(SupplierEntity, SupplierDto.class);
    }

    @Override
    public SupplierEntity mapFrom(SupplierDto SupplierDto) {
        return modelMapper.map(SupplierDto, SupplierEntity.class);
    }
}
