package com.example.reservationhotel.config;


import com.example.reservationhotel.security.auth.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {
    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }
}
class SpringSecurityAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserPrincipal userPrincipal) {

            // Trường hợp login bằng UserPrincipal (login thông thường)

            return Optional.ofNullable(userPrincipal.getId());
        } else if (principal instanceof OAuth2User oAuth2User) {
            // Trường hợp login qua OAuth2

            String email = (String) oAuth2User.getAttributes().get("email");

            return Optional.empty();  // Hoặc bạn có thể sử dụng một cách khác để lấy ID nếu cần
        } else {
            return Optional.empty();
        }
    }
}