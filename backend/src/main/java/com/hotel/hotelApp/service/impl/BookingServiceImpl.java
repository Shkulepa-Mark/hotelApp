package com.hotel.hotelApp.service.impl;

import com.hotel.hotelApp.dto.BookingRequest;
import com.hotel.hotelApp.model.Booking;
import com.hotel.hotelApp.model.Room;
import com.hotel.hotelApp.model.User;
import com.hotel.hotelApp.repository.BookingRepository;
import com.hotel.hotelApp.repository.RoomRepository;
import com.hotel.hotelApp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Override
    @Transactional
    public Booking bookRoom(BookingRequest request, User user) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Комната не найдена"));

        if (!room.isAvailable()) {
            throw new IllegalStateException("Комната уже забронирована");
        }

        room.setAvailable(false);

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setUser(user);
        booking.setCheckIn(request.getCheckIn());
        booking.setCheckOut(request.getCheckOut());

        roomRepository.save(room);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(User user) {
        return bookingRepository.findByUser(user);
    }
}

