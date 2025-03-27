package com.example.reservationhotel.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Setter
@Getter
public class Address {
    @NotEmpty(message = "Street is required")
    private String street;

    @NotEmpty(message = "City is required")
    private String city;

    private String state;

    @Pattern(regexp = "\\d{6}", message = "Postcode must be 6 digits")
    private String postcode;

    private String country  ;
    private Double latitude;  // Vĩ độ
    private Double longitude; // Kinh độ
}

