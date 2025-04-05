package com.example.reservationhotel.repository;

import com.example.reservationhotel.model.HotelChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelChainRepository extends JpaRepository<HotelChain, Long> {
}
