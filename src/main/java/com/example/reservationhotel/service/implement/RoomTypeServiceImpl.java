package com.example.reservationhotel.service.implement;


import com.example.reservationhotel.dto.room.RoomTypeCreateDTO;
import com.example.reservationhotel.dto.room.RoomTypeResponseDTO;
import com.example.reservationhotel.model.RoomType;
import com.example.reservationhotel.repository.RoomTypeRepository;
import com.example.reservationhotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public RoomTypeResponseDTO createRoomType(RoomTypeCreateDTO roomTypeCreateDTO) {
        // Tạo RoomType
        RoomType roomType = RoomType.builder()
                .name(roomTypeCreateDTO.getName())
                .build();

        RoomType savedRoomType = roomTypeRepository.save(roomType);

        // Trả về DTO
        return RoomTypeResponseDTO.builder()
                .id(savedRoomType.getId())
                .name(savedRoomType.getName())
                .build();
    }

    @Override
    public List<RoomTypeResponseDTO> getAllRoomTypes() {
        return roomTypeRepository.findAll().stream()
                .map(roomType -> RoomTypeResponseDTO.builder()
                        .id(roomType.getId())
                        .name(roomType.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public RoomTypeResponseDTO getRoomTypeById(Long roomTypeId) {
        RoomType roomType = roomTypeRepository.findById(roomTypeId)
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        return RoomTypeResponseDTO.builder()
                .id(roomType.getId())
                .name(roomType.getName())
                .build();
    }
}