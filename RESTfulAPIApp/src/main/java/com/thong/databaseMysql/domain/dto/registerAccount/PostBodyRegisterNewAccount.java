package com.thong.databaseMysql.domain.dto.registerAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostBodyRegisterNewAccount {



    private String username;

    private String email;

    private String password;

    private String telNumber;

    private String authorities;

    private String fullName;

    private String shipAddress;

    private String shipCity;

    private String shipState;

    private String image;
}
