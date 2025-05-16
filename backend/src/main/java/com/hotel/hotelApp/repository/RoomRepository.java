package com.hotel.hotelApp.repository;

import com.hotel.hotelApp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsAvailableTrue();
    Optional<Room> findById(Long id);
}
