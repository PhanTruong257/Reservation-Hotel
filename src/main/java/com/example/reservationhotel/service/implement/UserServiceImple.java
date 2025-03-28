package com.example.reservationhotel.service.implement;

import com.example.reservationhotel.model.User;
import com.example.reservationhotel.repository.UserRepository;
import com.example.reservationhotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImple implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImple(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User registerUser(User user) {


            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);

    }

    @Override
    public User getCustomerBy(String username) {
        return null;
    }

    @Override
    public List<User> getAllCustomer() {
        return List.of();
    }

    @Override
    public Boolean existsByEmail(String username) {
        return userRepository.existsByEmail(username);
    }

    @Override
    public int getCount() {
        return (int) userRepository.count();
    }
}
