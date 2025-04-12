package com.example.reservationhotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomTypeResponseDTO {
    private Long id;       // ID của loại phòng
    private String name;   // Tên loại phòng
}