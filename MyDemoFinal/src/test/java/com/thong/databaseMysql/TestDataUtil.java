package com.thong.databaseMysql;


import com.thong.databaseMysql.domain.dto.ProductDto;
import com.thong.databaseMysql.domain.entities.ProductEntity;
import com.thong.databaseMysql.domain.entities.UserEntity;

public class TestDataUtil {
    public static UserEntity getUserEntityA() {
        UserEntity userEntity = UserEntity.builder()
                .id(1)
                .email("emailtest@gmail.com")
                .fullName("Tran Van Thong A")
                .isActive(true)
                .authorities("ROLE_ADMIN")
                .image("imagetest.png")
                .telNumber("0842190902")
                .shipAddress("KDC 2, lam binh")
                .shipCity("Quang Ngai")
                .shipState("Duc Pho")
                .username("username")
                .password("{noop}password")
                .build();
        return userEntity;
    }
    public static UserEntity getUserEntityB() {
        UserEntity userEntity = UserEntity.builder()
                .id(2)
                .email("emailtest@gmail.com")
                .fullName("Tran Van Thong B")
                .isActive(true)
                .authorities("ROLE_ADMIN")
                .image("imagetest.png")
                .telNumber("0842190902")
                .shipAddress("KDC 2, lam binh")
                .shipCity("Quang Ngai")
                .shipState("Duc Pho")
                .username("username")
                .password("{noop}password")
                .build();
        return userEntity;
    }
    public static UserEntity getUserEntityC() {
        UserEntity userEntity = UserEntity.builder()
                .id(3)
                .email("emailtest@gmail.com")
                .fullName("Tran Van Thong C")
                .isActive(true)
                .authorities("ROLE_ADMIN")
                .image("imagetest.png")
                .telNumber("0842190902")
                .shipAddress("KDC 2, lam binh")
                .shipCity("Quang Ngai")
                .shipState("Duc Pho")
                .username("username")
                .password("{noop}password")
                .build();
        return userEntity;
    }

    public static ProductEntity getProductEntityA()
    {
        ProductEntity product = ProductEntity.builder()
                .id(1)
                .productName("TEST PRODUCT A")
                .isActive(true)
                .quantity(100)
                .unitPrice(120000.00f)
                .build();
        return product;
    }
    public static ProductDto getProductDtoA()
    {
        ProductDto product = ProductDto.builder()
                .id(1)
                .productName("TEST PRODUCT A")
                .isActive(true)
                .quantity(100)
                .unitPrice(120000.00f)
                .build();
        return product;
    }
    public static ProductEntity getProductEntityB()
    {
        ProductEntity product = ProductEntity.builder()
                .id(2)
                .productName("TEST PRODUCT A")
                .isActive(true)
                .quantity(100)
                .unitPrice(120000.00f)
                .build();
        return product;
    }
    public static ProductEntity getProductEntityC()
    {
        ProductEntity product = ProductEntity.builder()
                .id(3)
                .productName("TEST PRODUCT A")
                .isActive(true)
                .quantity(100)
                .unitPrice(120000.00f)
                .build();
        return product;
    }

}
