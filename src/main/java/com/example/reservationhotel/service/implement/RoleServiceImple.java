package com.example.reservationhotel.service.implement;


import com.example.reservationhotel.model.role.Role;
import com.example.reservationhotel.model.role.RoleType;
import com.example.reservationhotel.repository.RoleRepository;
import com.example.reservationhotel.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImple implements RoleService {
    private final RoleRepository roleRepository;


    public RoleServiceImple(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findByName(RoleType roleType) {
        return roleRepository.findByName(roleType);
    }
}
