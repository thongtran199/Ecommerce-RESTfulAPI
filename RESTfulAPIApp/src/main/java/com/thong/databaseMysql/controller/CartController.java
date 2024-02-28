package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.CartDto;
import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.mappers.impl.CartMapper;
import com.thong.databaseMysql.services.CartService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class CartController {

    private CartService cartService;
    private CartMapper cartMapper;

    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

//    @PostMapping(path = "/cart")
//    public ResponseEntity<CartDto> postMapping(@RequestBody final CartDto productDto) {
//        CartEntity product = cartMapper.mapFrom(productDto);
//        CartEntity savedProduct = cartService.save(product);
//        return new ResponseEntity<>(cartMapper.mapTo(savedProduct), HttpStatus.CREATED);
//    }

//    @PutMapping(path = "/cart/{id}")
//    public ResponseEntity<CartDto> putMapping(@PathVariable("id") Integer id,
//                                                @RequestBody CartDto cartDto) {
//        cartDto.setId(id);
//        CartEntity cart = cartMapper.mapFrom(cartDto);
//        CartEntity savedCart = cartService.save(cart);
//        return new ResponseEntity<>(cartMapper.mapTo(savedCart), HttpStatus.CREATED);
//    }

    @GetMapping(path = "/cart")
    public List<CartDto> getMapping() {
        List<CartEntity> products = cartService.findAll();
        return products.stream()
                .map(entity -> cartMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/cart/{id}")
    public ResponseEntity<CartDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<CartEntity> foundProduct = cartService.findOne(id);
        return foundProduct.map(entity -> {
                    CartDto dto = cartMapper.mapTo(entity);
                    return new ResponseEntity<>(dto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
