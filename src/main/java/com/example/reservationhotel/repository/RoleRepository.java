package com.example.reservationhotel.repository;

import com.example.reservationhotel.model.role.Role;
import com.example.reservationhotel.model.role.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType role);
}
