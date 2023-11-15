package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.ReviewDto;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.domain.entities.ReviewEntity;
import com.thong.databaseMysql.domain.entities.UserEntity;
import com.thong.databaseMysql.mappers.impl.ReviewMapper;
import com.thong.databaseMysql.services.ProductService;
import com.thong.databaseMysql.services.ReviewService;
import com.thong.databaseMysql.services.UserService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class ReviewController {

    private ReviewService reviewService;
    private ProductService productService;
    private UserService userService;
    private ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper, ProductService productService, UserService userService) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
        this.productService = productService;
        this.userService = userService;
    }

    @PostMapping(path = "/review")
    public ResponseEntity<ReviewDto> postMapping(@RequestBody final ReviewDto reviewDto) {
        Optional<ProductEntity> result = productService.findOne(reviewDto.getProductId());
        Optional<UserEntity> resultUser = userService.findOne(reviewDto.getUserId());
        if(result.isEmpty() || resultUser.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ReviewEntity review = reviewMapper.mapFrom(reviewDto);

        review.setProductEntity(result.get());
        review.setUserEntity(resultUser.get());
        ReviewEntity savedReview = reviewService.save(review);
        return new ResponseEntity<>(reviewMapper.mapTo(savedReview), HttpStatus.CREATED);
    }

    @PutMapping(path = "/review/{id}")
    public ResponseEntity<ReviewDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody ReviewDto reviewDto) {
        reviewDto.setId(id);
        ReviewEntity review = reviewMapper.mapFrom(reviewDto);

        Optional<ProductEntity> result = productService.findOne(reviewDto.getProductId());
        Optional<UserEntity> resultUser = userService.findOne(reviewDto.getUserId());
        if(result.isEmpty() || resultUser.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        review.setProductEntity(result.get());
        review.setUserEntity(resultUser.get());

        ReviewEntity savedReview = reviewService.save(review);
        return new ResponseEntity<>(reviewMapper.mapTo(savedReview), HttpStatus.CREATED);
    }

    @GetMapping(path = "/review/{id}")
    public ResponseEntity<ReviewDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<ReviewEntity> foundReview = reviewService.findOne(id);
        return foundReview.map(entity -> {
                    ReviewDto reviewDto = reviewMapper.mapTo(entity);
                    return new ResponseEntity<>(reviewDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @GetMapping(path = "/review")
    public List<ReviewDto> getMapping() {
        List<ReviewEntity> reviews = reviewService.findAll();
        return reviews.stream()
                .map(entity -> reviewMapper.mapTo(entity))
                .collect(Collectors.toList());
    }
    @GetMapping(path = "/reviewByProductId/{id}")
    public List<ReviewDto> getReviewsByProductId(@PathVariable("id") Integer id) {
        List<ReviewEntity> reviews = reviewService.findAllByProductId(id);
        return reviews.stream()
                .map(entity->reviewMapper.mapTo(entity))
                .collect(Collectors.toList());
    }
}
