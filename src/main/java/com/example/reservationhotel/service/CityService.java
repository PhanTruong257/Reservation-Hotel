package com.example.reservationhotel.service;

import com.example.reservationhotel.dto.CityDTO;
import com.example.reservationhotel.model.City;

import java.util.List;

public interface CityService {
    List<CityDTO> getCitiesByCountryId(Long countryId);
    CityDTO save(CityDTO cityDTO);
    CityDTO updateCity(Long id, CityDTO cityDTO);
}