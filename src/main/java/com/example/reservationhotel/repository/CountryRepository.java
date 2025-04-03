package com.example.reservationhotel.repository;

import com.example.reservationhotel.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);



}
