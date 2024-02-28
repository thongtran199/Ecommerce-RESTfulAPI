package com.thong.databaseMysql.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thong.databaseMysql.domain.entities.CategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Integer id;

    private String productName;

    private Float unitPrice;

    private Integer quantity;

    private String color;

    private String image;

    private String description;

    private Boolean isActive;

    private SupplierDto supplierDto;

    private CategoryDto categoryDto;

}
