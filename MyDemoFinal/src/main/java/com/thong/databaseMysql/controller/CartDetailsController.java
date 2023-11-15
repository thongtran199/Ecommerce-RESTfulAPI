package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.CartDetailsDto;
import com.thong.databaseMysql.domain.dto.addToCart.PostBodyAddToCart;
import com.thong.databaseMysql.domain.entities.CartDetailsEntity;
import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.mappers.impl.CartDetailsMapper;
import com.thong.databaseMysql.services.CartDetailsService;
import com.thong.databaseMysql.services.CartService;
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
public class CartDetailsController {

    private CartDetailsService cartDetailsService;

    private CartService cartService;
    private ProductService productService;
    private CartDetailsMapper cartDetailsMapper;

    public CartDetailsController(CartDetailsService cartDetailsService,
                                 CartDetailsMapper cartDetailsMapper,
                                 ProductService productService, CartService cartService) {
        this.cartDetailsService = cartDetailsService;
        this.cartDetailsMapper = cartDetailsMapper;
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping(path = "/addToCart")
    public ResponseEntity<CartDetailsDto> postMapping(@RequestBody final PostBodyAddToCart postBodyAddToCart) {
        Optional<ProductEntity> foundProduct = productService.findOne(postBodyAddToCart.getProductId());
        if(foundProduct.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ProductEntity productEntity = foundProduct.get();

        //
        Optional<CartEntity> foundCart = cartService.findOne(1);
        CartEntity cartEntity = foundCart.get();
        CartDetailsEntity cartDetailsEntity = CartDetailsEntity.builder()
                .cartEntity(cartEntity)
                .productEntity(productEntity)
                .unitPrice(productEntity.getUnitPrice())
                .quantity(postBodyAddToCart.getQuantity())
                .build();
        CartDetailsEntity savedCartDetailsEntity = cartDetailsService.save(cartDetailsEntity);
        if(savedCartDetailsEntity != null) {
            cartEntity.setQuantity(cartEntity.getQuantity() + 1);
            CartEntity savedCartEntity = cartService.save(cartEntity);
            return new ResponseEntity<>(cartDetailsMapper.mapTo(savedCartDetailsEntity), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/cartDetails/{id}")
    public ResponseEntity<CartDetailsDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody CartDetailsDto cartDetailsDto) {
        cartDetailsDto.setId(id);
        CartDetailsEntity cartDetails = cartDetailsMapper.mapFrom(cartDetailsDto);
        CartDetailsEntity savedCartDetails = cartDetailsService.save(cartDetails);
        return new ResponseEntity<>(cartDetailsMapper.mapTo(savedCartDetails), HttpStatus.CREATED);
    }

    @GetMapping(path = "/cartDetails")
    public List<CartDetailsDto> getMapping() {
        List<CartDetailsEntity> cartDetailss = cartDetailsService.findAll();
        return cartDetailss.stream()
                .map(entity -> cartDetailsMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/cartDetails/{id}")
    public ResponseEntity<CartDetailsDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<CartDetailsEntity> foundProduct = cartDetailsService.findOne(id);
        return foundProduct.map(entity -> {
                    CartDetailsDto cartDetailsDto = cartDetailsMapper.mapTo(entity);
                    return new ResponseEntity<>(cartDetailsDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @GetMapping(path = "/removeFromCart/{id}")
    public ResponseEntity<CartDetailsDto> getRemoveFromCart(@PathVariable("id") Integer id) {
        Optional<CartDetailsEntity> foundCartDetail = cartDetailsService.findOne(id);
        if(foundCartDetail.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CartDetailsEntity cartDetailsEntity = foundCartDetail.get();

        CartEntity cartEntity = cartDetailsEntity.getCartEntity();


        cartDetailsService.deleteById(cartDetailsEntity.getId());

        cartEntity.setQuantity(cartEntity.getQuantity() - 1);
        CartEntity savedCartEntity = cartService.save(cartEntity);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
