package com.thong.databaseMysql.domain.dto.addToCart;

import com.thong.databaseMysql.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostBodyAddToCart {
    private Integer productId;
    private Integer quantity;
}
