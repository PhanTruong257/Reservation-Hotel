package com.example.reservationhotel.service;

import com.example.reservationhotel.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getCustomerBy(String username);
    List<User> getAllCustomer();
    Boolean existsByEmail(String username);



    int getCount();
}
