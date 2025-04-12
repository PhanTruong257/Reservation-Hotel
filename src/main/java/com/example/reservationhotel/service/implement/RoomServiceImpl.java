package com.example.reservationhotel.service.implement;



import com.example.reservationhotel.dto.room.RoomCreateDTO;
import com.example.reservationhotel.dto.room.RoomResponseDTO;
import com.example.reservationhotel.model.Hotel;
import com.example.reservationhotel.model.Room;
import com.example.reservationhotel.model.RoomAvailability;
import com.example.reservationhotel.model.RoomType;
import com.example.reservationhotel.repository.HotelRepository;
import com.example.reservationhotel.repository.RoomRepository;
import com.example.reservationhotel.repository.RoomTypeRepository;
import com.example.reservationhotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;



    @Override
    public RoomResponseDTO createRoom(RoomCreateDTO roomCreateDTO) {
        // Kiểm tra hotelId
        Hotel hotel = hotelRepository.findById(roomCreateDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        // Kiểm tra roomTypeId
        RoomType roomType = roomTypeRepository.findById(roomCreateDTO.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("RoomType not found"));



        // Tạo Room
        Room room = Room.builder()
                .name(roomCreateDTO.getName())
                .hotel(hotel)
                .roomAvailabilityId(roomCreateDTO.getRoomAvailabilityId())
                .roomType(roomType)
                .build();

        Room savedRoom = roomRepository.save(room);

        // Trả về DTO
        return RoomResponseDTO.builder()
                .id(savedRoom.getId())
                .name(savedRoom.getName())
                .hotelId(savedRoom.getHotel().getId())
                .roomAvailabilityId(roomCreateDTO.getRoomAvailabilityId())
                .roomTypeId(savedRoom.getRoomType().getId())
                .build();
    }

    @Override
    public RoomResponseDTO getRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return RoomResponseDTO.builder()
                .id(room.getId())
                .name(room.getName())
                .hotelId(room.getHotel().getId())
                .roomTypeId(room.getRoomType().getId())
                .build();
    }

    @Override
    public List<RoomResponseDTO> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(room -> RoomResponseDTO.builder()
                        .id(room.getId())
                        .name(room.getName())
                        .hotelId(room.getHotel().getId())
                        .roomTypeId(room.getRoomType().getId())
                        .build())
                .collect(Collectors.toList());
    }
}