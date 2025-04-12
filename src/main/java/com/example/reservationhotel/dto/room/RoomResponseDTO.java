package com.example.reservationhotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponseDTO {
    private Long id;             // ID của phòng
    private String name;         // Tên phòng
    private Long hotelId;        // ID của khách sạn
    private Long roomTypeId;     // ID của loại phòng
    private Long roomAvailabilityId; // ID của trạng thái khả dụng
}