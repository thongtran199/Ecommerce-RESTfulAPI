package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.ReviewDto;
import com.thong.databaseMysql.domain.entities.ReviewEntity;
import com.thong.databaseMysql.mappers.Mapper;
import com.thong.databaseMysql.services.ProductService;
import com.thong.databaseMysql.services.UserService;
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
        ReviewDto reviewDto= modelMapper.map(ReviewEntity, ReviewDto.class);
        reviewDto.setProductId(ReviewEntity.getProductEntity().getId());
        reviewDto.setUserId(ReviewEntity.getUserEntity().getId());
        return reviewDto;
    }

    @Override
    public ReviewEntity mapFrom(ReviewDto ReviewDto) {
        ReviewEntity reviewEntity =  modelMapper.map(ReviewDto, ReviewEntity.class);
        return reviewEntity;
    }
}
