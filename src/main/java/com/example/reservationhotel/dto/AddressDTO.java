package com.example.reservationhotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public   class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postcode;
}