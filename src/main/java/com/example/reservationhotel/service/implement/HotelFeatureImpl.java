package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.dto.HotelFeatureDTO;
import com.example.reservationhotel.exception.ResourceNotFoundException;
import com.example.reservationhotel.model.HotelFeature;
import com.example.reservationhotel.repository.HotelFeatureRepository;
import com.example.reservationhotel.service.HotelFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelFeatureImpl implements HotelFeatureService {

    @Autowired
    private HotelFeatureRepository hotelFeatureRepository;

    @Override
    public List<HotelFeatureDTO> getAllHotelFeatures() {
        List<HotelFeature> features = hotelFeatureRepository.findAll();
        return features.stream()
                .map(feature -> new HotelFeatureDTO(feature.getId(), feature.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public HotelFeatureDTO getHotelFeatureById(Long id) {
        HotelFeature feature = hotelFeatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HotelFeature", "id", id));
        return new HotelFeatureDTO(feature.getId(), feature.getName());
    }

    @Override
    public HotelFeatureDTO createHotelFeature(HotelFeatureDTO hotelFeatureDTO) {
        HotelFeature feature = new HotelFeature();
        feature.setName(hotelFeatureDTO.getName());
        HotelFeature savedFeature = hotelFeatureRepository.save(feature);
        return new HotelFeatureDTO(savedFeature.getId(), savedFeature.getName());
    }

    @Override
    public HotelFeatureDTO updateHotelFeature(Long id, HotelFeatureDTO hotelFeatureDTO) {
        HotelFeature feature = hotelFeatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HotelFeature", "id", id));
        feature.setName(hotelFeatureDTO.getName());
        HotelFeature updatedFeature = hotelFeatureRepository.save(feature);
        return new HotelFeatureDTO(updatedFeature.getId(), updatedFeature.getName());
    }

    @Override
    public void deleteHotelFeature(Long id) {
        HotelFeature feature = hotelFeatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HotelFeature", "id", id));
        hotelFeatureRepository.delete(feature);
    }
}