package com.thong.databaseMysql.services.impl;

import com.thong.databaseMysql.domain.entities.CategoryEntity;
import com.thong.databaseMysql.repositories.CategoryRepository;
import com.thong.databaseMysql.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return StreamSupport.stream(
                categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryEntity> findOne(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return categoryRepository.existsById(id);
    }
}
