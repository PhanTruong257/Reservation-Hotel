package com.example.reservationhotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "hotelChain", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Hotel> hotels;



}
