package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.ProductDto;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<ProductEntity, ProductDto> {

    private CategoryMapper categoryMapper;
    private SupplierMapper supplierMapper;
    private ModelMapper modelMapper;
    public ProductMapper(ModelMapper modelMapper, CategoryMapper categoryMapper, SupplierMapper supplierMapper){
        this.modelMapper = modelMapper;
        this.categoryMapper = categoryMapper;
        this.supplierMapper = supplierMapper;

    }
    @Override
    public ProductDto mapTo(ProductEntity productEntity) {
        ProductDto productDto =  modelMapper.map(productEntity, ProductDto.class);
//        productDto.setCategoryDto(categoryMapper.mapTo(productEntity.getCategoryEntity()));
//        productDto.setSupplierDto(supplierMapper.mapTo(productEntity.getSupplierEntity()));
        return productDto;

    }

    @Override
    public ProductEntity mapFrom(ProductDto productDto) {
        return modelMapper.map(productDto, ProductEntity.class);
    }
}
