package com.example.reservationhotel.dto.hotel;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
