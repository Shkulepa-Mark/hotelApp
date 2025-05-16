package com.hotel.hotelApp.service;

import com.hotel.hotelApp.dto.BookingRequest;
import com.hotel.hotelApp.model.Booking;
import com.hotel.hotelApp.model.User;

import java.util.List;

public interface BookingService {
    Booking bookRoom(BookingRequest request, User user);
    List<Booking> getUserBookings(User user);
}

