package com.hotel.hotelApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    @NotNull(message = "ID номера не может быть пустым")
    private Long roomId;

    @NotNull(message = "Дата заезда не может быть пустой")
    private LocalDateTime checkIn;

    @NotNull(message = "Дата выезда не может быть пустой")
    private LocalDateTime checkOut;
}
