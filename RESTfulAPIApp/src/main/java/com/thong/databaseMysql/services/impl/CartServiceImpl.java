package com.thong.databaseMysql.services.impl;

import com.thong.databaseMysql.domain.entities.CartDetailsEntity;
import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.domain.entities.OrderDetailsEntity;
import com.thong.databaseMysql.domain.entities.OrderEntity;
import com.thong.databaseMysql.repositories.CartDetailsRepository;
import com.thong.databaseMysql.repositories.CartRepository;
import com.thong.databaseMysql.services.CartService;
import com.thong.databaseMysql.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private CartDetailsRepository cartDetailsRepository;

    public CartServiceImpl(CartRepository cartRepository, CartDetailsRepository cartDetailsRepository) {
        this.cartRepository = cartRepository;
        this.cartDetailsRepository = cartDetailsRepository;
    }


    @Override
    public CartEntity save(CartEntity cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<CartEntity> findAll() {
        return StreamSupport.stream(
                cartRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CartEntity> findOne(Integer id) {
        return cartRepository.findById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return cartRepository.existsById(id);
    }

    @Override
    public CartEntity updateQuantity(Integer cartId) {
        Optional<CartEntity> foundCart = findOne(cartId);
        CartEntity cartEntity = foundCart.get();
        List<CartDetailsEntity> cartDetailsEntityList = cartDetailsRepository.findAllByCartId(cartId);
        cartEntity.setQuantity(cartDetailsEntityList.size());
        CartEntity updatedCart = cartRepository.save(cartEntity);
        return updatedCart;
    }
}
