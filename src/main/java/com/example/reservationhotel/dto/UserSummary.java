package com.example.reservationhotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSummary {

    private String username;
    private String firstName;
    private String email;
    private String phone;
}