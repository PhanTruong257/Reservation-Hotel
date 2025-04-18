package com.example.reservationhotel.controller;

import com.example.reservationhotel.dto.UserSummary;
import com.example.reservationhotel.exception.ResourceNotFoundException;
import com.example.reservationhotel.model.User;
import com.example.reservationhotel.security.auth.CurrentUser;
import com.example.reservationhotel.security.auth.UserPrincipal;
import com.example.reservationhotel.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<UserSummary> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        User user = userService.getCustomerBy(currentUser.getEmail())
                .orElseThrow();
        UserSummary userSummary = new UserSummary(user.getFirstName(), user.getLastName(), user.getEmail(),user.getPhone());
        return ResponseEntity.ok(userSummary);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        User user = userService.getUserById(id);
        System.out.println(user.getRole());
        // Trả về ResponseEntity với mã 200 nếu người dùng tồn tại
        return ResponseEntity.ok(user);
    }






}
