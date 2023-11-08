package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.ReviewDto;
import com.thong.databaseMysql.domain.entities.ReviewEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper implements Mapper<ReviewEntity, ReviewDto> {
    private ModelMapper modelMapper;
    public ReviewMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public ReviewDto mapTo(ReviewEntity ReviewEntity) {
        return modelMapper.map(ReviewEntity, ReviewDto.class);
    }

    @Override
    public ReviewEntity mapFrom(ReviewDto ReviewDto) {
        return modelMapper.map(ReviewDto, ReviewEntity.class);
    }
}
