package com.example.reservationhotel.controller;


import com.example.reservationhotel.dto.room.RoomTypeCreateDTO;
import com.example.reservationhotel.dto.room.RoomTypeResponseDTO;
import com.example.reservationhotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    // Tạo một loại phòng mới
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RoomTypeResponseDTO> createRoomType(@RequestBody RoomTypeCreateDTO roomTypeCreateDTO) {
        RoomTypeResponseDTO createdRoomType = roomTypeService.createRoomType(roomTypeCreateDTO);
        return ResponseEntity.ok(createdRoomType);
    }

    // Lấy danh sách tất cả các loại phòng
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<RoomTypeResponseDTO>> getAllRoomTypes() {
        List<RoomTypeResponseDTO> roomTypes = roomTypeService.getAllRoomTypes();
        return ResponseEntity.ok(roomTypes);
    }

    // Lấy loại phòng theo ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<RoomTypeResponseDTO> getRoomTypeById(@PathVariable Long id) {
        RoomTypeResponseDTO roomType = roomTypeService.getRoomTypeById(id);
        return ResponseEntity.ok(roomType);
    }
}