package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.OrderDetailsDto;
import com.thong.databaseMysql.domain.entities.OrderDetailsEntity;
import com.thong.databaseMysql.domain.entities.OrderEntity;
import com.thong.databaseMysql.mappers.impl.OrderDetailsMapper;
import com.thong.databaseMysql.services.OrderDetailsService;
import com.thong.databaseMysql.services.OrderService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;
    private OrderService orderService;
    private OrderDetailsMapper orderDetailsMapper;

    public OrderDetailsController(OrderDetailsService orderDetailsService,
                                  OrderDetailsMapper orderDetailsMapper,
                                  OrderService orderService) {
        this.orderDetailsService = orderDetailsService;
        this.orderDetailsMapper = orderDetailsMapper;
        this.orderService = orderService;
    }

    @PutMapping(path = "/orderDetails/{id}")
    public ResponseEntity<OrderDetailsDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody OrderDetailsDto orderDetailsDto) {
        orderDetailsDto.setId(id);
        OrderDetailsEntity orderDetails = orderDetailsMapper.mapFrom(orderDetailsDto);
        OrderDetailsEntity savedOrderDetails = orderDetailsService.save(orderDetails);
        return new ResponseEntity<>(orderDetailsMapper.mapTo(savedOrderDetails), HttpStatus.CREATED);
    }

    @GetMapping(path = "/orderDetails")
    public List<OrderDetailsDto> getMapping() {
        List<OrderDetailsEntity> orderDetailss = orderDetailsService.findAll();
        return orderDetailss.stream()
                .map(entity -> orderDetailsMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/orderDetails/{id}")
    public ResponseEntity<OrderDetailsDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<OrderDetailsEntity> foundOrderDetails = orderDetailsService.findOne(id);
        return foundOrderDetails.map(entity -> {
                    OrderDetailsDto orderDetailsDto = orderDetailsMapper.mapTo(entity);
                    return new ResponseEntity<>(orderDetailsDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @GetMapping(path = "/deleteOrderDetails/{id}")
    public ResponseEntity<OrderDetailsDto> deleteOrderDetails(@PathVariable("id") Integer id) {
        Optional<OrderDetailsEntity> foundOrderDetails = orderDetailsService.findOne(id);
        if(foundOrderDetails.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        OrderDetailsEntity orderDetailsEntity = foundOrderDetails.get();
        orderDetailsService.deleteById(orderDetailsEntity.getId());

        OrderEntity orderEntity = orderDetailsEntity.getOrderEntity();
        OrderEntity updatedOrder =  orderService.updateTotal(orderEntity.getId());
        return new ResponseEntity<>(orderDetailsMapper.mapTo(orderDetailsEntity), HttpStatus.OK);

    }
}
