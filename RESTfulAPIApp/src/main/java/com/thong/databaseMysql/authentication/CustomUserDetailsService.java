//package com.thong.databaseMysql.authentication;
//
//import com.thong.databaseMysql.domain.entities.UserEntity;
//import com.thong.databaseMysql.services.UserService;
//import jakarta.servlet.ServletException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//import java.util.Optional;
//
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("CHUAN BI TIM");
//        UserEntity userEntity =  userService.findByUserName(username);
//        if(userEntity == null)
//        {
//            System.out.println("KHONG TIM THAY NGUOI DUNG USERNAME "+ username);
//            throw new UsernameNotFoundException("Khong tim thay nguoi dung co username: "+username);
//        }
//
//        return new CustomUserDetails(userEntity);
//    }
//    public UserDetails loadUserById(Integer userId) throws ServletException {
//        Optional<UserEntity> result =  userService.findOne(userId);
//        if(!result.isPresent())
//        {
//            System.out.println("KHONG TIM THAY NGUOI DUNG CO ID "+userId);
//            throw new ServletException("Khong tim thay nguoi dung co id: "+ userId);
//        }
//
//        return new CustomUserDetails(result.get());
//    }
//}
