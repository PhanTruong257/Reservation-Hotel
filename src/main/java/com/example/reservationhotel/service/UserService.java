package com.example.reservationhotel.service;

import com.example.reservationhotel.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getCustomerBy(String username);
    List<User> getAllCustomer();
}
