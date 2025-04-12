package com.example.reservationhotel.controller;

import com.example.reservationhotel.dto.hotel.HotelChainDTO;
import com.example.reservationhotel.service.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-chains")
public class HotelChainController {

    @Autowired
    private HotelChainService hotelChainService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<HotelChainDTO>> getAllHotelChains() {
        List<HotelChainDTO> hotelChains = hotelChainService.getHotelChains();
        return ResponseEntity.ok(hotelChains);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<HotelChainDTO> getHotelChainById(@PathVariable Long id) {
        HotelChainDTO hotelChain = hotelChainService.getHotelChainById(id);
        return ResponseEntity.ok(hotelChain);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HotelChainDTO> createHotelChain(@RequestBody HotelChainDTO hotelChainDTO) {
        HotelChainDTO createdHotelChain = hotelChainService.addHotelChain(hotelChainDTO);
        return ResponseEntity.status(201).body(createdHotelChain);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HotelChainDTO> updateHotelChain(@PathVariable Long id, @RequestBody HotelChainDTO hotelChainDTO) {
        HotelChainDTO updatedHotelChain = hotelChainService.updateHotelChain(id, hotelChainDTO);
        return ResponseEntity.ok(updatedHotelChain);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteHotelChain(@PathVariable Long id) {
        hotelChainService.deleteHotelChain(id);
        return ResponseEntity.noContent().build();
    }
}