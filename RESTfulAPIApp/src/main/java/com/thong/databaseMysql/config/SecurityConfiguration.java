//package com.thong.databaseMysql.config;
//
//import com.thong.databaseMysql.authentication.CustomUserDetailsService;
//import com.thong.databaseMysql.authentication.JwtAuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.CachingUserDetailsService;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
////@EnableWebSecurity
//public class SecurityConfiguration {
//    @Bean
//    public CustomUserDetailsService customUserDetailsService()
//    {
//        return new CustomUserDetailsService();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests -> requests
////                        .requestMatchers(HttpMethod.PUT,"/category").hasAnyAuthority("ROLE_ADMIN", "ROLE_CALLCENTER")
////                        .requestMatchers("/user").hasAuthority("ROLE_ADMIN")
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(withDefaults())
//                .formLogin(form -> form
//                        .disable() // Disable form-based login
//                )
//                .logout(logout -> logout
//                        .permitAll())
//                .csrf(csrf -> csrf.disable());
////        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(customUserDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//}
