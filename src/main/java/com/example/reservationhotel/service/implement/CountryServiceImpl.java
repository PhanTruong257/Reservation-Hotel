package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.dto.CountryDTO;
import com.example.reservationhotel.exception.ResourceNotFoundException;
import com.example.reservationhotel.model.Country;
import com.example.reservationhotel.repository.CountryRepository;
import com.example.reservationhotel.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryDTO getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
        return new CountryDTO(country.getId(), country.getName(), null);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Long id, CountryDTO countryDTO) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));

        country.setName(countryDTO.getName());

        return countryRepository.save(country);
    }
}