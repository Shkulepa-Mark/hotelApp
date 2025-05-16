package com.hotel.hotelApp.service;

import com.hotel.hotelApp.dto.RoomDTO;
import com.hotel.hotelApp.model.Room;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAvailableRooms();
    Room getRoomById(Long id);
}

