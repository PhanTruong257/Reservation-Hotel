package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.dto.*;
import com.example.reservationhotel.exception.ResourceNotFoundException;
import com.example.reservationhotel.model.*;
import com.example.reservationhotel.repository.*;
import com.example.reservationhotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired private HotelRepository hotelRepository;
    @Autowired private AddressRepository addressRepository;
    @Autowired private HotelChainRepository hotelChainRepository;
    @Autowired private HotelFeatureRepository hotelFeatureRepository;

    @Override
    public List<HotelResponseDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponseDTO getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));
        return convertToResponseDTO(hotel);
    }

    @Override
    public HotelResponseDTO createHotel(HotelRequestDTO dto) {
        Address address = addressRepository.findById(dto.getAddressId())
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", dto.getAddressId()));
        HotelChain hotelChain = hotelChainRepository.findById(dto.getHotelChainId())
                .orElseThrow(() -> new ResourceNotFoundException("HotelChain", "id", dto.getHotelChainId()));
        Set<HotelFeature> features = new HashSet<>();
        if (dto.getFeatureIds() != null) {
            features = new HashSet<>(hotelFeatureRepository.findAllById(dto.getFeatureIds()));
        }

        Hotel hotel = Hotel.builder()
                .name(dto.getName())
                .address(address)
                .hotelChain(hotelChain)
                .rating(dto.getRating())
                .features(features)
                .build();

        Hotel savedHotel = hotelRepository.save(hotel);
        return convertToResponseDTO(savedHotel);
    }

    @Override
    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO dto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));

        hotel.setName(dto.getName());
        hotel.setRating(dto.getRating());

        Address address = addressRepository.findById(dto.getAddressId())
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", dto.getAddressId()));
        HotelChain hotelChain = hotelChainRepository.findById(dto.getHotelChainId())
                .orElseThrow(() -> new ResourceNotFoundException("HotelChain", "id", dto.getHotelChainId()));
        Set<HotelFeature> features = new HashSet<>();
        if (dto.getFeatureIds() != null) {
            features = new HashSet<>(hotelFeatureRepository.findAllById(dto.getFeatureIds()));
        }

        hotel.setAddress(address);
        hotel.setHotelChain(hotelChain);
        hotel.setFeatures(features);

        Hotel updatedHotel = hotelRepository.save(hotel);
        return convertToResponseDTO(updatedHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));
        hotelRepository.delete(hotel);
    }

    private HotelResponseDTO convertToResponseDTO(Hotel hotel) {
        return HotelResponseDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .rating(hotel.getRating())
                .address(convertToAddressDTO(hotel.getAddress()))
                .hotelChain(convertToHotelChainDTO(hotel.getHotelChain()))
                .features(hotel.getFeatures().stream()
                        .map(this::convertToFeatureDTO)
                        .collect(Collectors.toSet()))
                .build();
    }

    private AddressDTO convertToAddressDTO(Address address) {
        return AddressDTO.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    private HotelChainDTO convertToHotelChainDTO(HotelChain chain) {
        return HotelChainDTO.builder()
                .id(chain.getId())
                .name(chain.getName())
                .build();
    }

    private HotelFeatureDTO convertToFeatureDTO(HotelFeature feature) {
        return HotelFeatureDTO.builder()
                .id(feature.getId())
                .name(feature.getName())
                .build();
    }
}
