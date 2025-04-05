package com.example.reservationhotel.service;

import com.example.reservationhotel.dto.CountryDTO;
import com.example.reservationhotel.model.Country;

import java.util.List;

public interface CountryService {
    CountryDTO getCountryById(Long id);
    Country save(Country country);
    Country updateCountry(Long id, CountryDTO countryDTO);
    List<CountryDTO> getAllCountries();
}