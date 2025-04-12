package com.example.reservationhotel.service;

import com.example.reservationhotel.dto.room.RoomCreateDTO;
import com.example.reservationhotel.dto.room.RoomResponseDTO;

import java.util.List;

public interface RoomService {
    RoomResponseDTO createRoom(RoomCreateDTO roomCreateDTO); // Tạo phòng mới
    RoomResponseDTO getRoomById(Long roomId); // Lấy thông tin phòng theo ID
    List<RoomResponseDTO> getAllRooms(); // Lấy danh sách tất cả phòng
}