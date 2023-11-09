package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.CartDetailsDto;
import com.thong.databaseMysql.domain.entities.CartDetailsEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartDetailsMapper implements Mapper<CartDetailsEntity, CartDetailsDto> {
    private ModelMapper modelMapper;
    public CartDetailsMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public CartDetailsDto mapTo(CartDetailsEntity CartDetailsEntity) {
        return modelMapper.map(CartDetailsEntity, CartDetailsDto.class);
    }

    @Override
    public CartDetailsEntity mapFrom(CartDetailsDto CartDetailsDto) {
        return modelMapper.map(CartDetailsDto, CartDetailsEntity.class);
    }
}
