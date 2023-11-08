package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.CategoryDto;
import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<CategoryEntity, CategoryDto> {
    private ModelMapper modelMapper;
    public CategoryMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public CategoryDto mapTo(CategoryEntity CategoryEntity) {
        return modelMapper.map(CategoryEntity, CategoryDto.class);
    }

    @Override
    public CategoryEntity mapFrom(CategoryDto CategoryDto) {
        return modelMapper.map(CategoryDto, CategoryEntity.class);
    }
}
