package com.thong.databaseMysql.services.impl;

import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.repositories.ProductRepository;
import com.thong.databaseMysql.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductEntity> findAll() {
        return StreamSupport.stream(
                productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductEntity> findOne(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<ProductEntity> findAllByColor(String color) {
        return productRepository.findAllByColor(color);
    }

    @Override
    public List<ProductEntity> findAllByUnitPrice(Float minPrice, Float maxPrice) {
        return productRepository.findAllByUnitPrice(minPrice, maxPrice);
    }

    @Override
    public List<ProductEntity> findAllByProductName(String productName) {
        return productRepository.findAllByProductName(productName);
    }

    @Override
    public Page<ProductEntity> findAllByIsActiveTrue(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return productRepository.findAllByIsActiveTrue(pageable);
    }
}
