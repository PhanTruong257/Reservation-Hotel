package com.example.reservationhotel.service;


import com.example.reservationhotel.dto.AddressDTO;

public interface AddressService {

    AddressDTO getAddressById(Long id);

    AddressDTO addAddress(AddressDTO addressDTO);






}
