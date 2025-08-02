package com.example.Stock_Manager.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //  Needed for Postman POST requests
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 🔓 Allow all endpoints
                )
                .httpBasic(httpBasic -> httpBasic.disable()); // Disable basic auth the modern way

        return http.build();
    }
}
