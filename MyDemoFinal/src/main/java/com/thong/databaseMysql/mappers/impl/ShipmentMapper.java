package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.ShipmentDto;
import com.thong.databaseMysql.domain.entities.ShipmentEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper implements Mapper<ShipmentEntity, ShipmentDto> {
    private ModelMapper modelMapper;
    public ShipmentMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public ShipmentDto mapTo(ShipmentEntity ShipmentEntity) {
        return modelMapper.map(ShipmentEntity, ShipmentDto.class);
    }

    @Override
    public ShipmentEntity mapFrom(ShipmentDto ShipmentDto) {
        return modelMapper.map(ShipmentDto, ShipmentEntity.class);
    }
}
