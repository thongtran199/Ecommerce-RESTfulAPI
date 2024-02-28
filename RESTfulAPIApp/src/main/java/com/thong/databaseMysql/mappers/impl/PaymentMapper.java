package com.thong.databaseMysql.mappers.impl;

import com.thong.databaseMysql.domain.dto.PaymentDto;
import com.thong.databaseMysql.domain.entities.PaymentEntity;
import com.thong.databaseMysql.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper implements Mapper<PaymentEntity, PaymentDto> {
    private ModelMapper modelMapper;
    public PaymentMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }
    @Override
    public PaymentDto mapTo(PaymentEntity PaymentEntity) {
        return modelMapper.map(PaymentEntity, PaymentDto.class);
    }

    @Override
    public PaymentEntity mapFrom(PaymentDto PaymentDto) {
        return modelMapper.map(PaymentDto, PaymentEntity.class);
    }
}
