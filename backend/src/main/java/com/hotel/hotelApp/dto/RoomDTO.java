package com.hotel.hotelApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private String name;
    private boolean isAvailable;
    private String bleDeviceId;
}
