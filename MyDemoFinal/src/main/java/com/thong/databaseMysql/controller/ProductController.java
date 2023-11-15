package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.ProductDto;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.mappers.impl.ProductMapper;
import com.thong.databaseMysql.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
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
    public Page<ProductDto> getMapping(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ProductEntity> productPage = productService.findAllByIsActiveTrue(page, size);
        return productPage.map(productMapper::mapTo);
    }
    @GetMapping(path = "/product/filterByColor/{color}")
    public List<ProductDto> filterByColor(@PathVariable("color") String color) {
        List<ProductEntity> productEntities = productService.findAllByColor(color);
        return productEntities.stream().map(entity -> productMapper.mapTo(entity)).collect(Collectors.toList());
    }
    @GetMapping(path = "/product/filterByPrice")
    public List<ProductDto> filterByPrice(@RequestParam("minPrice") Float minPrice,
                                          @RequestParam("maxPrice") Float maxPrice) {
        List<ProductEntity> productEntities = productService.findAllByUnitPrice(minPrice, maxPrice);
        return productEntities.stream().map(entity -> productMapper.mapTo(entity)).collect(Collectors.toList());
    }
    @GetMapping(path = "/product/filterByName/{name}")
    public List<ProductDto> filterByName(@PathVariable("name") String name) {
        List<ProductEntity> productEntities = productService.findAllByProductName(name);
        return productEntities.stream().map(entity -> productMapper.mapTo(entity)).collect(Collectors.toList());
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
