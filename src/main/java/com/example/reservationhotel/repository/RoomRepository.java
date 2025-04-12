package com.example.reservationhotel.repository;

import com.example.reservationhotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByName(String name); // Tìm phòng theo tên
    List<Room> findByHotelId(Long hotelId); // Lấy danh sách phòng theo khách sạn
    List<Room> findByRoomTypeId(Long roomTypeId); // Lấy danh sách phòng theo loại phòng
}