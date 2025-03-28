package com.example.reservationhotel.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String Email;

    @NotBlank
    private String password;
}
