package com.rafael0117.HotelApp.application.dto.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {
    private String usuario;
    private String password;
}
