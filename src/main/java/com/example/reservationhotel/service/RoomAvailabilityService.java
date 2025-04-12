package com.example.reservationhotel.service;



import com.example.reservationhotel.dto.room.RoomAvailabilityCreateDTO;
import com.example.reservationhotel.dto.room.RoomAvailabilityResponseDTO;

import java.util.List;

public interface RoomAvailabilityService {
    RoomAvailabilityResponseDTO createRoomAvailability(RoomAvailabilityCreateDTO roomAvailabilityCreateDTO); // Tạo trạng thái khả dụng
    List<RoomAvailabilityResponseDTO> getRoomAvailability(Long roomId); // Lấy danh sách trạng thái khả dụng của phòng
    RoomAvailabilityResponseDTO getAvailabilityById(Long availabilityId); // Lấy trạng thái khả dụng theo ID
}