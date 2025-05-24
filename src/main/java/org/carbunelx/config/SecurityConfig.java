// src/main/java/org/carbunelx/config/SecurityConfig.java
package org.carbunelx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/signup-form", "/user/signup", "/signup", "/signup.html").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/user/login-form") // set your custom login page if you have one
                .permitAll()
            );
        return http.build();
    }
}