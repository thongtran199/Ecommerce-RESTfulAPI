package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.ProductDto;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.mappers.impl.ProductMapper;
import com.thong.databaseMysql.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping(path = "/product")
    public ResponseEntity<ProductDto> postMapping(@RequestBody final ProductDto productDto) {
        ProductEntity product = productMapper.mapFrom(productDto);
        ProductEntity savedProduct = productService.save(product);
        return new ResponseEntity<>(productMapper.mapTo(savedProduct), HttpStatus.CREATED);
    }

    @PutMapping(path = "/product/{id}")
    public ResponseEntity<ProductDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody ProductDto productDto) {
        productDto.setId(id);
        ProductEntity product = productMapper.mapFrom(productDto);
        ProductEntity savedProduct = productService.save(product);
        return new ResponseEntity<>(productMapper.mapTo(savedProduct), HttpStatus.CREATED);
    }

    @GetMapping(path = "/product")
    public List<ProductDto> getMapping() {
        List<ProductEntity> products = productService.findAll();
        return products.stream()
                .map(entity -> productMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<ProductDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<ProductEntity> foundProduct = productService.findOne(id);
        return foundProduct.map(entity -> {
                    ProductDto productDto = productMapper.mapTo(entity);
                    return new ResponseEntity<>(productDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
