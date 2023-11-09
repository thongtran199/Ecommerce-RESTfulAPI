package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.CartDto;
import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartMapper implements Mapper<CartEntity, CartDto> {
    private ModelMapper modelMapper;
    public CartMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public CartDto mapTo(CartEntity CartEntity) {
        return modelMapper.map(CartEntity, CartDto.class);
    }

    @Override
    public CartEntity mapFrom(CartDto CartDto) {
        return modelMapper.map(CartDto, CartEntity.class);
    }
}
