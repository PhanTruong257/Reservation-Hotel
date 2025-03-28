package com.example.reservationhotel.service;

import com.example.reservationhotel.model.role.Role;
import com.example.reservationhotel.model.role.RoleType;

public interface RoleService {

    public Role findByName(RoleType roleType);
}
