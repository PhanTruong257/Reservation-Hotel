package com.example.reservationhotel.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${cors.allowedOrigins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        final long MAX_AGE_SECS = 3600;

        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins) // Đọc từ application.properties
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Các method được phép
                .allowedHeaders("*") // Cho phép mọi header
                .maxAge(MAX_AGE_SECS); // Cache preflight trong 1 giờ
    }
}
