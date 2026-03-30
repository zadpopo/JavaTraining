package com.bpi.traning.M9_module.config;

import com.bpi.traning.M9_module.security.CustomAccessDeniedHandler;
import com.bpi.traning.M9_module.security.CustomAuthEntryPoint;
import com.bpi.traning.M9_module.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


@Bean
    SecurityFilterChain filterChain(HttpSecurity http,
                                    CustomUserDetailsService service,
                                    CustomAuthEntryPoint customEntryPoint,
                                    CustomAccessDeniedHandler accessDeniedHandler) throws Exception {


        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/**").permitAll()
                .requestMatchers("/home").hasAnyRole("USER", "MANAGER")
                .requestMatchers("/dashboard").hasRole("USER")
                .requestMatchers("/reports").hasRole("MANAGER")
                .anyRequest().authenticated()
        );

        http.httpBasic(basic -> {});

        http.exceptionHandling(ex -> ex
                .authenticationEntryPoint(customEntryPoint) 
                .accessDeniedHandler(accessDeniedHandler)  
        );

        http.authenticationProvider(authProvider(service));
        return http.build();
    }


    @Bean
    DaoAuthenticationProvider authProvider(CustomUserDetailsService service) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}