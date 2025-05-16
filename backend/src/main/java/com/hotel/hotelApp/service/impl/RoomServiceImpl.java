package com.hotel.hotelApp.service.impl;

import com.hotel.hotelApp.dto.RoomDTO;
import com.hotel.hotelApp.model.Room;
import com.hotel.hotelApp.repository.RoomRepository;
import com.hotel.hotelApp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<RoomDTO> getAvailableRooms() {
        return roomRepository.findByIsAvailableTrue().stream()
                .map(room -> new RoomDTO(room.getId(), room.getName(), room.isAvailable(), room.getBleDeviceId()))
                .toList();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Комната не найдена"));
    }
}

