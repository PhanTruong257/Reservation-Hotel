package com.example.reservationhotel.repository;

import com.example.reservationhotel.dto.AddressDTO;
import com.example.reservationhotel.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {

}
