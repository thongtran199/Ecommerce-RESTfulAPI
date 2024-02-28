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
public class CartDetailsDto {
    private Integer id;

//    private CartDto cartDto;

    private ProductDto productDto;

    private Float unitPrice;

    private Integer quantity;
}
