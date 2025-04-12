package com.example.reservationhotel.service;


import com.example.reservationhotel.dto.room.RoomTypeCreateDTO;
import com.example.reservationhotel.dto.room.RoomTypeResponseDTO;

import java.util.List;

public interface RoomTypeService {
    RoomTypeResponseDTO createRoomType(RoomTypeCreateDTO roomTypeCreateDTO); // Tạo loại phòng
    List<RoomTypeResponseDTO> getAllRoomTypes(); // Lấy danh sách tất cả loại phòng
    RoomTypeResponseDTO getRoomTypeById(Long roomTypeId); // Lấy loại phòng theo ID
}