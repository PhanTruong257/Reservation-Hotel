package com.example.reservationhotel.service.implement;


import com.example.reservationhotel.dto.room.RoomAvailabilityCreateDTO;
import com.example.reservationhotel.dto.room.RoomAvailabilityResponseDTO;
import com.example.reservationhotel.model.Room;
import com.example.reservationhotel.model.RoomAvailability;

import com.example.reservationhotel.repository.RoomAvailabilityRepository;
import com.example.reservationhotel.repository.RoomRepository;
import com.example.reservationhotel.service.RoomAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomAvailabilityServiceImpl implements RoomAvailabilityService {

    @Autowired
    private RoomAvailabilityRepository roomAvailabilityRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomAvailabilityResponseDTO createRoomAvailability(RoomAvailabilityCreateDTO roomAvailabilityCreateDTO) {

        RoomAvailability availability = RoomAvailability.builder()

                .availableFrom(roomAvailabilityCreateDTO.getAvailableFrom())
                .availableTo(roomAvailabilityCreateDTO.getAvailableTo())
                .isAvailable(roomAvailabilityCreateDTO.isAvailable())
                .build();

        RoomAvailability savedAvailability = roomAvailabilityRepository.save(availability);

        // Trả về DTO
        return RoomAvailabilityResponseDTO.builder()
                .id(savedAvailability.getId())

                .availableFrom(savedAvailability.getAvailableFrom())
                .availableTo(savedAvailability.getAvailableTo())
                .isAvailable(savedAvailability.isAvailable())
                .build();
    }

    @Override
    public List<RoomAvailabilityResponseDTO> getRoomAvailability(Long roomId) {
        return roomAvailabilityRepository.findByRoomId(roomId).stream()
                .map(availability -> RoomAvailabilityResponseDTO.builder()
                        .id(availability.getId())


                        .availableTo(availability.getAvailableTo())
                        .isAvailable(availability.isAvailable())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public RoomAvailabilityResponseDTO getAvailabilityById(Long availabilityId) {
        RoomAvailability availability = roomAvailabilityRepository.findById(availabilityId)
                .orElseThrow(() -> new RuntimeException("Room availability not found"));

        return RoomAvailabilityResponseDTO.builder()
                .id(availability.getId())
               
                .availableFrom(availability.getAvailableFrom())
                .availableTo(availability.getAvailableTo())
                .isAvailable(availability.isAvailable())
                .build();
    }
}