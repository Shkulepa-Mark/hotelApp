package com.hotel.hotelApp.controller;

import com.hotel.hotelApp.dto.BookingRequest;
import com.hotel.hotelApp.model.Booking;
import com.hotel.hotelApp.model.User;
import com.hotel.hotelApp.service.BookingService;
import com.hotel.hotelApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Booking> bookRoom(
            @RequestBody BookingRequest request,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        User user = userService.findByLoginOrEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        Booking booking = bookingService.bookRoom(request, user);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getUserBookings(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByLoginOrEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return ResponseEntity.ok(bookingService.getUserBookings(user));
    }
}

