package com.thong.databaseMysql.domain.dto.authentication;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {


    private Integer id;

    private String username;

    private String email;

    private String telNumber;

    private String authorities;

    private String fullName;

    private String shipAddress;

    private String shipCity;

    private String shipState;

    private Boolean isActive;

    private String image;
}
