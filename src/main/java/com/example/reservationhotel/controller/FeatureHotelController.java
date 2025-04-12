package com.example.reservationhotel.controller;

import com.example.reservationhotel.dto.hotel.HotelFeatureDTO;
import com.example.reservationhotel.service.HotelFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feature-hotel")
public class FeatureHotelController {

    @Autowired
    private HotelFeatureService hotelFeatureService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<HotelFeatureDTO>> getAllHotelFeatures() {
        List<HotelFeatureDTO> features = hotelFeatureService.getAllHotelFeatures();
        return ResponseEntity.ok(features);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<HotelFeatureDTO> getHotelFeatureById(@PathVariable Long id) {
        HotelFeatureDTO feature = hotelFeatureService.getHotelFeatureById(id);
        return ResponseEntity.ok(feature);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HotelFeatureDTO> createHotelFeature(@RequestBody HotelFeatureDTO hotelFeatureDTO) {
        HotelFeatureDTO createdFeature = hotelFeatureService.createHotelFeature(hotelFeatureDTO);
        return ResponseEntity.status(201).body(createdFeature);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HotelFeatureDTO> updateHotelFeature(@PathVariable Long id, @RequestBody HotelFeatureDTO hotelFeatureDTO) {
        HotelFeatureDTO updatedFeature = hotelFeatureService.updateHotelFeature(id, hotelFeatureDTO);
        return ResponseEntity.ok(updatedFeature);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteHotelFeature(@PathVariable Long id) {
        hotelFeatureService.deleteHotelFeature(id);
        return ResponseEntity.noContent().build();
    }
}