package com.thong.databaseMysql.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDto {
    private Integer id;

    private OrderDto orderDto;

    private ProductDto productDto;

    private Integer quantity;

    private Float unitPrice;
}
