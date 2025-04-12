package com.example.reservationhotel.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {

    private Long id;
    private String name;
    private Long addressId;
    private Long hotelChainId;
    private int rating;
    private Set<HotelFeatureDTO> features;

}
