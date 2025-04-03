package com.example.reservationhotel.config;


import com.example.reservationhotel.security.auth.JwtAuthenticationEntryPoint;
import com.example.reservationhotel.security.auth.JwtAuthenticationFilter;
import com.example.reservationhotel.service.implement.CustomUserDetailsImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsImple customUserDetailsImple;
    private final JwtAuthenticationEntryPoint unauthorizedHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(PasswordEncoder passwordEncoder, CustomUserDetailsImple customUserDetailsImple, JwtAuthenticationEntryPoint unauthorizedHandler, JwtAuthenticationFilter jwtAuthenticationFilter, AccessDeniedHandler accessDeniedHandler) {
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsImple = customUserDetailsImple;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.accessDeniedHandler = accessDeniedHandler;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configure(http)) // Cấu hình CORS mới
                .csrf(csrf -> csrf.disable()) // Disable CSRF nếu cần
                .exceptionHandling(eh -> eh.authenticationEntryPoint(unauthorizedHandler)
                                                                                .accessDeniedHandler(accessDeniedHandler))
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                );

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() { // provider gọi DaoAuthenticationProvider thực hiện xác thực
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsImple); // chỉ định custoimUserDetail làm database
        authProvider.setPasswordEncoder(passwordEncoder);// nếu user tồn tại thì kiểm tra password
        return new ProviderManager(List.of(authProvider));
    }


}