package com.example.reservationhotel.repository;


import com.example.reservationhotel.model.HotelFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelFeatureRepository extends JpaRepository<HotelFeature, Long> {

    // Custom query methods can be defined here if needed
}
