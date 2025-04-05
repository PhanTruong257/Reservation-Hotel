package com.example.reservationhotel.controller;

import com.example.reservationhotel.dto.CityDTO;
import com.example.reservationhotel.model.City;
import com.example.reservationhotel.model.Country;
import com.example.reservationhotel.service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")  // Thêm /api để chỉ ra endpoint API
public class CityController {

    @Autowired
    private CityService cityService;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CityDTO> createCity(@Valid @RequestBody CityDTO cityDTO) {

        CityDTO savedCity = cityService.save(cityDTO);
        CityDTO resultDTO = new CityDTO(savedCity.getId(),  savedCity.getName(), savedCity.getCountryId());

        return ResponseEntity.status(201).body(resultDTO);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        CityDTO updatedCity = cityService.updateCity(id, cityDTO);
        CityDTO resultDTO = new CityDTO(updatedCity.getId(), updatedCity.getName(), updatedCity.getCountryId());
        return ResponseEntity.ok(resultDTO);
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/country/{countryId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<CityDTO>> getCitiesByCountryId(@PathVariable Long countryId) {
        List<CityDTO> cities = cityService.getCitiesByCountryId(countryId);
        return ResponseEntity.ok(cities);
    }

}