package com.example.reservationhotel.controller;


import com.example.reservationhotel.dto.room.RoomAvailabilityCreateDTO;
import com.example.reservationhotel.dto.room.RoomAvailabilityResponseDTO;
import com.example.reservationhotel.service.RoomAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-availabilities")
public class RoomAvailabilityController {

    @Autowired
    private RoomAvailabilityService roomAvailabilityService;

    // Tạo trạng thái khả dụng mới
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RoomAvailabilityResponseDTO> createRoomAvailability(@RequestBody RoomAvailabilityCreateDTO roomAvailabilityCreateDTO) {
        RoomAvailabilityResponseDTO createdAvailability = roomAvailabilityService.createRoomAvailability(roomAvailabilityCreateDTO);
        return ResponseEntity.ok(createdAvailability);
    }

    // Lấy danh sách trạng thái khả dụng của phòng
    @GetMapping("/room/{roomId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<RoomAvailabilityResponseDTO>> getRoomAvailability(@PathVariable Long roomId) {
        List<RoomAvailabilityResponseDTO> availabilities = roomAvailabilityService.getRoomAvailability(roomId);
        return ResponseEntity.ok(availabilities);
    }

    // Lấy trạng thái khả dụng theo ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<RoomAvailabilityResponseDTO> getAvailabilityById(@PathVariable Long id) {
        RoomAvailabilityResponseDTO availability = roomAvailabilityService.getAvailabilityById(id);
        return ResponseEntity.ok(availability);
    }
}