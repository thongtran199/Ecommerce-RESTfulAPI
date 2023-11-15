package com.thong.databaseMysql.services.impl;

import com.thong.databaseMysql.domain.entities.CartDetailsEntity;
import com.thong.databaseMysql.domain.entities.CartEntity;
import com.thong.databaseMysql.repositories.CartDetailsRepository;
import com.thong.databaseMysql.repositories.CartRepository;
import com.thong.databaseMysql.services.CartDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {
    private CartDetailsRepository cartDetailsRepository;
    private CartRepository cartRepository;

    public CartDetailsServiceImpl(CartDetailsRepository cartDetailsRepository, CartRepository cartRepository) {
        this.cartDetailsRepository = cartDetailsRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public CartDetailsEntity save(CartDetailsEntity cartDetails) {
        return cartDetailsRepository.save(cartDetails);
    }

    @Override
    public List<CartDetailsEntity> findAll() {
        return StreamSupport.stream(
                cartDetailsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CartDetailsEntity> findOne(Integer id) {
        return cartDetailsRepository.findById(id);
    }

    @Override
    public boolean isExist(Integer id) {
        return cartDetailsRepository.existsById(id);
    }


    @Override
    public void deleteById(Integer id) {
        cartDetailsRepository.deleteById(id);
    }

}
