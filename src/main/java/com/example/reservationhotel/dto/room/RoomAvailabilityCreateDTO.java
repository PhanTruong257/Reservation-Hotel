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
public class RoomAvailabilityCreateDTO {
    private Long roomId;              // ID của phòng
    private LocalDate availableFrom;  // Ngày bắt đầu khả dụng
    private LocalDate availableTo;    // Ngày kết thúc khả dụng
    private boolean isAvailable;      // Trạng thái khả dụng (true: trống, false: đã đặt)
}