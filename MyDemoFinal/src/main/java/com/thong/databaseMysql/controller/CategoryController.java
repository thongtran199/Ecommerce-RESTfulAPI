package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.CategoryDto;
import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.mappers.impl.CategoryMapper;
import com.thong.databaseMysql.services.CategoryService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping(path = "/category")
    public ResponseEntity<CategoryDto> postMapping(@RequestBody final CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categoryMapper.mapFrom(categoryDto);
        CategoryEntity savedCategory = categoryService.save(categoryEntity);
        return new ResponseEntity<>(categoryMapper.mapTo(savedCategory), HttpStatus.CREATED);
    }

    @PutMapping(path = "/category/{id}")
    public ResponseEntity<CategoryDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        CategoryEntity categoryEntity = categoryMapper.mapFrom(categoryDto);
        CategoryEntity savedCategory = categoryService.save(categoryEntity);
        return new ResponseEntity<>(categoryMapper.mapTo(savedCategory), HttpStatus.CREATED);
    }

    @GetMapping(path = "/category")
    public List<CategoryDto> getMapping() {
        List<CategoryEntity> categories = categoryService.findAll();
        return categories.stream()
                .map(entity -> categoryMapper.mapTo(entity))
                .collect(Collectors.toList());
//        return categories;
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<CategoryDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<CategoryEntity> foundCategory = categoryService.findOne(id);
        return foundCategory.map(entity -> {
                    CategoryDto categoryDto = categoryMapper.mapTo(entity);
                    return new ResponseEntity<>(categoryDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
