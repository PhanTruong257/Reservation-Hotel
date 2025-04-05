package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.dto.AddressDTO;
import com.example.reservationhotel.exception.ResourceNotFoundException;
import com.example.reservationhotel.model.Address;
import com.example.reservationhotel.repository.AddressRepository;
import com.example.reservationhotel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDTO getAddressById(Long id) {

        return addressRepository.findById(id)
                .map(address -> AddressDTO.builder()
                        .street(address.getStreet())
                        .city(address.getCity())
                        .state(address.getState())
                        .country(address.getCountry())
                        .postcode(address.getPostcode())
                        .build())
                .orElseThrow(() -> new ResourceNotFoundException("address", "id", id));
    }

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address = new Address();
            address.setStreet(addressDTO.getStreet());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setCountry(addressDTO.getCountry());
            address.setPostcode(addressDTO.getPostcode());
        Address savedAddress = addressRepository.save(address);
        return new AddressDTO(savedAddress.getStreet(),
                savedAddress.getCity(),
                savedAddress.getState(),
                savedAddress.getCountry(),
                savedAddress.getPostcode());
    }

}
