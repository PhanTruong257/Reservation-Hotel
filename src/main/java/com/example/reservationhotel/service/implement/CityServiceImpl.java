package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.dto.CityDTO;
import com.example.reservationhotel.exception.ResourceNotFoundException;
import com.example.reservationhotel.model.City;
import com.example.reservationhotel.model.Country;
import com.example.reservationhotel.repository.CityRepository;
import com.example.reservationhotel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDTO> getCitiesByCountryId(Long countryId) {
        // Implement the method to get cities by country ID
        return null;
    }

    @Override
    public CityDTO save(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());

        Country country = new Country();
        country.setId(cityDTO.getCountryId());
        city.setCountry(country);

        City savedCity = cityRepository.save(city);
        return new CityDTO(  savedCity.getName(), savedCity.getCountry().getId());
    }

    @Override
    public CityDTO updateCity(Long id, CityDTO cityDTO) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

        city.setName(cityDTO.getName());

        Country country = new Country();
        country.setId(cityDTO.getCountryId());
        city.setCountry(country);

        City updatedCity = cityRepository.save(city);
        return new CityDTO(  updatedCity.getName(), updatedCity.getCountry().getId());
    }
}