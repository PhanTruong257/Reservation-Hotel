package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsImple implements CustomUserDetailsService,UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserById(Long id) {
        return null;
    }
}
