package com.thong.databaseMysql.domain.dto.authentication;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {

    private String username;
    private String password;
}
