package com.example.reservationhotel.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private String postcode;

    // Nếu bạn muốn mỗi địa chỉ chỉ thuộc về một khách sạn
    @OneToOne(mappedBy = "address")
    private Hotel hotel;
}
