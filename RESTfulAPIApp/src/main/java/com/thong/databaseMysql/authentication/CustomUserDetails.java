//package com.thong.databaseMysql.authentication;
//
//import com.thong.databaseMysql.domain.entities.UserEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//public class CustomUserDetails implements UserDetails {
//    private UserEntity userEntity;
//    public CustomUserDetails(UserEntity userEntity)
//    {
//        this.userEntity = userEntity;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(userEntity.getAuthorities()));
//
//    }
//
//    public UserEntity getUserEntity()
//    {
//        return this.userEntity;
//    }
//    @Override
//    public String getPassword() {
//        return userEntity.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userEntity.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
