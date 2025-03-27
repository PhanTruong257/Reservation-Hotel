package com.example.reservationhotel.service;

import com.example.reservationhotel.model.Customer;

import java.util.List;

public interface UserService {
    Customer registerUser(Customer user);
    Customer getCustomerBy(String username);
    List<Customer> getAllCustomer();
}
