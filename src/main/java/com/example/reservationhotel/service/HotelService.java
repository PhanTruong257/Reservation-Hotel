package com.example.reservationhotel.service;

import com.example.reservationhotel.dto.hotel.HotelRequestDTO;
import com.example.reservationhotel.dto.hotel.HotelResponseDTO;

import java.util.List;

public interface HotelService {

    List<HotelResponseDTO> getAllHotels();

    HotelResponseDTO getHotelById(Long id);

    HotelResponseDTO createHotel(HotelRequestDTO hotelDTO);

    HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelDTO);

    void deleteHotel(Long id);
}
