package com.hotel.hotelApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "Почта обязательна!")
    private String email;

    @NotBlank(message = "Логин обязателен!")
    private String login;

    @NotBlank(message = "Пароль обязателен!")
    private String password;
}