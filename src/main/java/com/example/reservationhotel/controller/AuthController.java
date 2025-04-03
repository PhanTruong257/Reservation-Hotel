package com.example.reservationhotel.controller;


import com.example.reservationhotel.dto.ApiResponse;
import com.example.reservationhotel.dto.JwtResponse;
import com.example.reservationhotel.dto.LoginRequest;
import com.example.reservationhotel.dto.SignUpRequest;
import com.example.reservationhotel.exception.BadRequestException;
import com.example.reservationhotel.model.User;
import com.example.reservationhotel.model.role.Role;
import com.example.reservationhotel.model.role.RoleType;
import com.example.reservationhotel.repository.RoleRepository;
import com.example.reservationhotel.repository.UserRepository;
import com.example.reservationhotel.security.auth.JwtTokenProvider;
import com.example.reservationhotel.service.RoleService;
import com.example.reservationhotel.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final RoleService roleService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, RoleService roleService, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email is already in use");
        }

        // Tạo user mới
        User user = new User(
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getPhone()
        );


        Role userRole = roleService.findByName(RoleType.ROLE_USER);
        if (userService.getCount() == 0) { // Nếu là user đầu tiên, thêm quyền ADMIN
            userRole = roleService.findByName(RoleType.ROLE_ADMIN);
        }
        user.setRole(userRole); // Chỉ gán một role duy nhất


        // Lưu user vào database
        User savedUser = userService.registerUser(user);

        // Trả về kết quả
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/users/{userId}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully", 201));
    }
    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new ApiResponse(true, "Login successful", 200, new JwtResponse(jwt)));
    }
}
