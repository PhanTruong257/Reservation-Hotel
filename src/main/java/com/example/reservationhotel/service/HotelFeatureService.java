package com.example.reservationhotel.service;

import com.example.reservationhotel.dto.HotelFeatureDTO;

import java.util.List;

public interface HotelFeatureService {
    List<HotelFeatureDTO> getAllHotelFeatures();
    HotelFeatureDTO getHotelFeatureById(Long id);
    HotelFeatureDTO createHotelFeature(HotelFeatureDTO hotelFeatureDTO);
    HotelFeatureDTO updateHotelFeature(Long id, HotelFeatureDTO hotelFeatureDTO);
    void deleteHotelFeature(Long id);
    
    
}

