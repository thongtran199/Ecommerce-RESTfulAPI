package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.OrderDto;
import com.thong.databaseMysql.domain.entities.OrderEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<OrderEntity, OrderDto> {
    private ModelMapper modelMapper;
    public OrderMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public OrderDto mapTo(OrderEntity OrderEntity) {
        return modelMapper.map(OrderEntity, OrderDto.class);
    }

    @Override
    public OrderEntity mapFrom(OrderDto OrderDto) {
        return modelMapper.map(OrderDto, OrderEntity.class);
    }
}
