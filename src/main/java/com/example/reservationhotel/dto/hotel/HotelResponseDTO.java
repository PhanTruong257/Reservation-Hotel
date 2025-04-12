package com.example.reservationhotel.dto.hotel;
import com.example.reservationhotel.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelResponseDTO {
    private Long id;
    private String name;
    private AddressDTO address;
    private HotelChainDTO hotelChain;
    private int rating;
    private Set<HotelFeatureDTO> features;
}
