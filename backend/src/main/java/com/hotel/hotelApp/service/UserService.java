package com.hotel.hotelApp.service;

import com.hotel.hotelApp.dto.AuthRequest;
import com.hotel.hotelApp.model.User;

import java.util.Optional;

public interface UserService {
    User register(AuthRequest request);
    Optional<User> findByLoginOrEmail(String loginOrEmail);
}
