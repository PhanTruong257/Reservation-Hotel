package com.example.reservationhotel.service;

import com.example.reservationhotel.dto.hotel.HotelChainDTO;

import java.util.List;

public interface HotelChainService {

    HotelChainDTO addHotelChain(HotelChainDTO hotelChainDTO);
    HotelChainDTO updateHotelChain(Long id, HotelChainDTO hotelChainDTO);
    void deleteHotelChain(Long id);
    List<HotelChainDTO> getHotelChains();
    HotelChainDTO getHotelChainById(Long id); // Added method
}