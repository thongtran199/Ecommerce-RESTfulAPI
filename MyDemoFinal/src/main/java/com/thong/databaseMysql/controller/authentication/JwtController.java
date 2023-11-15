//package com.thong.databaseMysql.controller.authentication;
//
//import com.thong.databaseMysql.authentication.CustomUserDetails;
//import com.thong.databaseMysql.authentication.JwtProviderToken;
//import com.thong.databaseMysql.domain.dto.authentication.LoginRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class JwtController {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    JwtProviderToken tokenProvider;
//    @PostMapping( path = "/custom-login")
//    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        System.out.println("CHUAN BI XAC THUC CUSTOM-LOGIN");
//        // Xác thực từ username và password.
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        // Nếu không xảy ra exception tức là thông tin hợp lệ
//        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Trả về jwt cho người dùng.
//        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
//        return ResponseEntity.ok(jwt);
//    }
//    // Api /api/random yêu cầu phải xác thực mới có thể request
//    @GetMapping("/random")
//    public String randomStuff(){
//        return "JWT Hợp lệ mới có thể thấy được message này";
//    }
//}
