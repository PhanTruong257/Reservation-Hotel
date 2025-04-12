package com.example.reservationhotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomAvailabilityResponseDTO {
    private Long id;              // ID của trạng thái khả dụng
    private Long roomId;          // ID của phòng
    private LocalDate availableFrom; // Ngày bắt đầu khả dụng
    private LocalDate availableTo;   // Ngày kết thúc khả dụng
    private boolean isAvailable;     // Trạng thái khả dụng
}