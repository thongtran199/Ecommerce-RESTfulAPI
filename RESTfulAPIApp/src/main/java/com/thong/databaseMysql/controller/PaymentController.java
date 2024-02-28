package com.thong.databaseMysql.controller;


import com.thong.databaseMysql.domain.dto.PaymentDto;
import com.thong.databaseMysql.domain.entities.PaymentEntity;
import com.thong.databaseMysql.mappers.impl.PaymentMapper;
import com.thong.databaseMysql.services.PaymentService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@RestController
public class PaymentController {

    private PaymentService paymentService;
    private PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping(path = "/payment")
    public ResponseEntity<PaymentDto> postMapping(@RequestBody final PaymentDto paymentDto) {
        PaymentEntity payment = paymentMapper.mapFrom(paymentDto);
        PaymentEntity savedPayment = paymentService.save(payment);
        return new ResponseEntity<>(paymentMapper.mapTo(savedPayment), HttpStatus.CREATED);
    }

    @PutMapping(path = "/payment/{id}")
    public ResponseEntity<PaymentDto> putMapping(@PathVariable("id") Integer id,
                                                @RequestBody PaymentDto paymentDto) {
        paymentDto.setId(id);
        PaymentEntity payment = paymentMapper.mapFrom(paymentDto);
        PaymentEntity savedPayment = paymentService.save(payment);
        return new ResponseEntity<>(paymentMapper.mapTo(savedPayment), HttpStatus.CREATED);
    }

    @GetMapping(path = "/payment")
    public List<PaymentDto> getMapping() {
        List<PaymentEntity> payments = paymentService.findAll();
        return payments.stream()
                .map(entity -> paymentMapper.mapTo(entity))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/payment/{id}")
    public ResponseEntity<PaymentDto> getMappingIsbn(@PathVariable("id") Integer id) {
        Optional<PaymentEntity> foundPayment = paymentService.findOne(id);
        return foundPayment.map(entity -> {
                    PaymentDto paymentDto = paymentMapper.mapTo(entity);
                    return new ResponseEntity<>(paymentDto, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
