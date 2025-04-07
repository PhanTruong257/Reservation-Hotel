package com.example.reservationhotel.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRequestDTO {
    private String name;
    private Long addressId;
    private Long hotelChainId;
    private int rating;
    private Set<Long> featureIds; // nếu cần
}
