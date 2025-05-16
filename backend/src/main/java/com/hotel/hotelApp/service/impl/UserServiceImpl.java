package com.hotel.hotelApp.service.impl;

import com.hotel.hotelApp.dto.AuthRequest;
import com.hotel.hotelApp.model.User;
import com.hotel.hotelApp.repository.UserRepository;
import com.hotel.hotelApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(AuthRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent() ||
                userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким email или логином уже существует");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByLoginOrEmail(String loginOrEmail) {
        return userRepository.findByLoginOrEmail(loginOrEmail);
    }
}
