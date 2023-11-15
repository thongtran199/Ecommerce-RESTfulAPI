package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.CartDetailsDto;
import com.thong.databaseMysql.domain.dto.OrderDto;
import com.thong.databaseMysql.domain.dto.PaymentDto;
import com.thong.databaseMysql.domain.dto.ShipmentDto;
import com.thong.databaseMysql.domain.entities.*;
import com.thong.databaseMysql.mappers.impl.CartDetailsMapper;
import com.thong.databaseMysql.mappers.impl.OrderMapper;
import com.thong.databaseMysql.mappers.impl.PaymentMapper;
import com.thong.databaseMysql.mappers.impl.ShipmentMapper;
import com.thong.databaseMysql.services.*;
import lombok.extern.java.Log;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private CartService cartService;
    private CartDetailsService cartDetailsService;
    private OrderDetailsService orderDetailsService;
    private ShipmentService shipmentService;
    private PaymentService paymentService;
    private OrderMapper orderMapper;
    private CartDetailsMapper cartDetailsMapper;
    private PaymentMapper paymentMapper;
    private ShipmentMapper shipmentMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper, PaymentMapper paymentMapper,
                           ShipmentMapper shipmentMapper, ShipmentService shipmentService, PaymentService paymentService
                            ,CartDetailsMapper cartDetailsMapper, CartDetailsService cartDetailsService,
                           OrderDetailsService orderDetailsService, UserService userService, CartService cartService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.shipmentMapper = shipmentMapper;
        this.paymentMapper = paymentMapper;
        this.shipmentService = shipmentService;
        this.paymentService = paymentService;
        this.cartDetailsMapper = cartDetailsMapper;
        this.cartDetailsService = cartDetailsService;
        this.orderDetailsService = orderDetailsService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping(path = "/order")
    public ResponseEntity<OrderDto> postMapping(@RequestBody final List<Integer> idCartDetailsList) {
        Date orderDate = new Date(Calendar.getInstance().getTime().getTime());

        //
        Optional<UserEntity> userEntity = userService.findOne(1);
        UserEntity user = userEntity.get();

        Float total = 0f;
        OrderEntity orderEntity = OrderEntity.builder()
                .orderDate(orderDate)
                .total(0.0f)
                .status(0)
                .isActive(true)
                .userEntity(user)
                .build();
        Boolean flag = true;
        List<OrderDetailsEntity> orderDetailsEntityList = new ArrayList<>();
        List<CartDetailsEntity> cartDetailsEntityList = new ArrayList<>();

        CartEntity cartEntity = null;

        for (Integer idCartDetails: idCartDetailsList) {
            Optional<CartDetailsEntity> foundCartDetails = cartDetailsService.findOne(idCartDetails);
            if(foundCartDetails.isEmpty())
            {
                flag = false;
                break;
            }
            CartDetailsEntity cartDetailsEntity = foundCartDetails.get();

            cartEntity = cartDetailsEntity.getCartEntity();

            cartDetailsEntityList.add(cartDetailsEntity);

            OrderDetailsEntity orderDetailsEntity = OrderDetailsEntity.builder()
                    .orderEntity(orderEntity)
                    .productEntity(cartDetailsEntity.getProductEntity())
                    .unitPrice(cartDetailsEntity.getUnitPrice())
                    .quantity(cartDetailsEntity.getQuantity())
                    .build();

            total += orderDetailsEntity.getUnitPrice() * orderDetailsEntity.getQuantity();
            orderDetailsEntityList.add(orderDetailsEntity);
        }
        if(flag == false)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderEntity.setTotal(total);
        OrderEntity savedOrder = orderService.save(orderEntity);
        for (OrderDetailsEntity orderDetailsEntity: orderDetailsEntityList) {
            OrderDetailsEntity saveOrderDetails = orderDetailsService.save(orderDetailsEntity);
        }
        for (CartDetailsEntity cartDetailsEntity: cartDetailsEntityList)
        {
            cartDetailsService.deleteById(cartDetailsEntity.getId());
        }

        cartService.updateQuantity(cartEntity.getId());

        return new ResponseEntity<>(orderMapper.mapTo(savedOrder), HttpStatus.CREATED);
    }

    @PutMapping(path = "/order/{id}")
    public ResponseEntity<OrderDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody OrderDto orderDto) {
        orderDto.setId(id);
        OrderEntity order = orderMapper.mapFrom(orderDto);
        OrderEntity savedOrder = orderService.save(order);
        return new ResponseEntity<>(orderMapper.mapTo(savedOrder), HttpStatus.CREATED);
    }

    @GetMapping(path = "/order")
    public List<OrderDto> getMapping() {
        List<OrderEntity> orders = orderService.findAll();
        return orders.stream()
                .map(entity -> orderMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/order/{id}")
    public ResponseEntity<OrderDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<OrderEntity> foundOrder = orderService.findOne(id);
        return foundOrder.map(entity -> {
                    OrderDto orderDto = orderMapper.mapTo(entity);
                    return new ResponseEntity<>(orderDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @GetMapping(path = "/deleteOrder/{id}")
    public ResponseEntity<OrderDto> getDeleteOrder(@PathVariable("id") Integer id) {
        Optional<OrderEntity> foundOrder = orderService.findOne(id);
        if(foundOrder.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        OrderEntity orderEntity = foundOrder.get();
        orderEntity.setIsActive(false);
        OrderEntity removedOrder = orderService.save(orderEntity);
        OrderDto orderDto = orderMapper.mapTo(removedOrder);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);


    }
    @PostMapping(path = "/setOrderIsShipping/{id}")
    public ResponseEntity<OrderDto> postSetOrderIsShipping(@PathVariable("id") Integer orderId,
                                                           @RequestParam("shipmentId") Integer shipmentId) {
        Optional<OrderEntity> foundOrder = orderService.findOne(orderId);
        if(foundOrder.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Optional<ShipmentEntity> foundShipment = shipmentService.findOne(shipmentId);
        if(foundShipment.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        OrderEntity orderEntity = foundOrder.get();
        orderEntity.setShipmentEntity(foundShipment.get());
        orderEntity.setStatus(1);
        OrderEntity savedOrder = orderService.save(orderEntity);
        if(savedOrder!=null)
        {
            return new ResponseEntity<>(orderMapper.mapTo(savedOrder), HttpStatus.OK);
        }
        return new ResponseEntity<>(orderMapper.mapTo(savedOrder), HttpStatus.NOT_FOUND);




    }
    @PostMapping(path = "/setOrderHasBeenPaid/{id}")
    public ResponseEntity<OrderDto> postSetOrderHasBeenPaid(@PathVariable("id") Integer orderId,
                                                            @RequestBody PaymentDto paymentDto) {
        Optional<OrderEntity> foundOrder = orderService.findOne(orderId);
        if(foundOrder.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        OrderEntity orderEntity = foundOrder.get();

        Optional<PaymentEntity> foundPayment = paymentService.findOneByCreditCard(paymentDto.getCreditCard());
        if(foundPayment.isEmpty())
        {

            PaymentEntity paymentEntity = paymentMapper.mapFrom(paymentDto);
            PaymentEntity savedPayment = paymentService.save(paymentEntity);
            orderEntity.setPaymentEntity(paymentEntity);

        }
        else {
            PaymentEntity paymentEntity = foundPayment.get();
            orderEntity.setPaymentEntity(paymentEntity);
        }
        Date paymentDate = new Date(Calendar.getInstance().getTime().getTime());
        orderEntity.setPaymentDate(paymentDate);
        orderEntity.setStatus(2);
        OrderEntity savedOrder = orderService.save(orderEntity);
        if(savedOrder!=null)
        {
            return new ResponseEntity<>(orderMapper.mapTo(savedOrder), HttpStatus.OK);
        }
        return new ResponseEntity<>(orderMapper.mapTo(savedOrder), HttpStatus.NOT_FOUND);
    }
}
