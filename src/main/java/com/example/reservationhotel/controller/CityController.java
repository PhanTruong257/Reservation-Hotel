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

@RestController
@RequestMapping("/api/cities")  // Thêm /api để chỉ ra endpoint API
public class CityController {

    @Autowired
    private CityService cityService;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CityDTO> createCity(@Valid @RequestBody CityDTO cityDTO) {

        CityDTO savedCity = cityService.save(cityDTO);
        CityDTO resultDTO = new CityDTO(  savedCity.getName(), savedCity.getCountryId());

        return ResponseEntity.status(201).body(resultDTO);  // Trả về mã 201 - Created
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        CityDTO updatedCity = cityService.updateCity(id, cityDTO);
        CityDTO resultDTO = new CityDTO( updatedCity.getName(), updatedCity.getCountryId());
        return ResponseEntity.ok(resultDTO);
    }
}