package com.example.reservationhotel.service.implement;


import com.example.reservationhotel.dto.HotelChainDTO;
import com.example.reservationhotel.model.HotelChain;
import com.example.reservationhotel.repository.HotelChainRepository;
import com.example.reservationhotel.service.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelChainServiceImpl implements HotelChainService {
    @Autowired
    private HotelChainRepository hotelChainRepository;



    @Override
    public HotelChainDTO addHotelChain(HotelChainDTO hotelChainDTO) {
        HotelChain hotelChain = new HotelChain();
        hotelChain.setName(hotelChainDTO.getName());

        HotelChain hotelChainSaved = hotelChainRepository.save(hotelChain);
        return new HotelChainDTO(hotelChainSaved.getId(), hotelChainSaved.getName());
    }

    @Override
    public HotelChainDTO updateHotelChain(Long id, HotelChainDTO hotelChainDTO) {
        return null;
    }

    @Override
    public void deleteHotelChain(Long id) {

    }

    @Override
    public List<HotelChainDTO> getHotelChains() {
        List<HotelChain> hotelChains = hotelChainRepository.findAll();
        return hotelChains.stream()
                .map(hotelChain -> new HotelChainDTO(hotelChain.getId(), hotelChain.getName()))
                .toList();

    }
}
