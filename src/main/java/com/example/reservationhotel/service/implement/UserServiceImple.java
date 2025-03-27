package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.model.User;
import com.example.reservationhotel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImple implements UserService {

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User getCustomerBy(String username) {
        return null;
    }

    @Override
    public List<User> getAllCustomer() {
        return List.of();
    }
}
