package com.example.reservationhotel.repository;

import com.example.reservationhotel.model.RoomAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {
    List<RoomAvailability> findByRoomId(Long roomId); // Lấy danh sách trạng thái khả dụng của phòng
    Optional<RoomAvailability> findByRoomIdAndAvailableFromAndAvailableTo(
            Long roomId,
            LocalDate availableFrom,
            LocalDate availableTo
    ); // Tìm trạng thái khả dụng theo phòng và khoảng thời gian
}