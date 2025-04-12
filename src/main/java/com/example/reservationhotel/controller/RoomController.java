package com.example.reservationhotel.controller;


import com.example.reservationhotel.dto.room.RoomCreateDTO;
import com.example.reservationhotel.dto.room.RoomResponseDTO;
import com.example.reservationhotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Tạo một phòng mới
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RoomResponseDTO> createRoom(@RequestBody RoomCreateDTO roomCreateDTO) {
        RoomResponseDTO createdRoom = roomService.createRoom(roomCreateDTO);
        return ResponseEntity.ok(createdRoom);
    }

    // Lấy thông tin phòng theo ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<RoomResponseDTO> getRoomById(@PathVariable Long id) {
        RoomResponseDTO room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }

    // Lấy danh sách tất cả các phòng
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<RoomResponseDTO>> getAllRooms() {
        List<RoomResponseDTO> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
}