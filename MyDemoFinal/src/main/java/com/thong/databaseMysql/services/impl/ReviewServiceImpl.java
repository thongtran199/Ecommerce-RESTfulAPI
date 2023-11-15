package com.thong.databaseMysql.services.impl;

import com.thong.databaseMysql.domain.entities.ReviewEntity;
import com.thong.databaseMysql.repositories.ReviewRepository;
import com.thong.databaseMysql.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public ReviewEntity save(ReviewEntity e) {
        return reviewRepository.save(e);
    }

    @Override
    public List<ReviewEntity> findAll() {
        return StreamSupport.stream(
                reviewRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReviewEntity> findOne(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return reviewRepository.existsById(id);
    }

    @Override
    public List<ReviewEntity> findAllByProductId(Integer productId) {
        return reviewRepository.findAllByProductId(productId);
    }
}
