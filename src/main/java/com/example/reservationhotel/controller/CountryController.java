package com.example.reservationhotel.controller;

import com.example.reservationhotel.dto.CountryDTO;
import com.example.reservationhotel.model.Country;
import com.example.reservationhotel.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/countries")  // Thêm /api để chỉ ra endpoint API
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable Long id) {
        CountryDTO countryDTO = countryService.getCountryById(id);
        return ResponseEntity.ok(countryDTO);
    }

    @PostMapping("add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CountryDTO> createCountry(@Valid @RequestBody CountryDTO countryDTO) {

        Country country = new Country();
        country.setName(countryDTO.getName());
        Country savedCountry = countryService.save(country);
        CountryDTO resultDTO = new CountryDTO(savedCountry.getId(), savedCountry.getName(), null);
        return ResponseEntity.status(201).body(resultDTO);  // Trả về mã 201 - Created
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        Country updatedCountry = countryService.updateCountry(id, countryDTO);  // Cập nhật quốc gia từ Service
        CountryDTO resultDTO = new CountryDTO(updatedCountry.getId(), updatedCountry.getName(), null);

        return ResponseEntity.ok(resultDTO);
    }
}
