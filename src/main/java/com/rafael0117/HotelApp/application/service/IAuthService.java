package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.login.LoginRequestDto;
import com.rafael0117.HotelApp.application.dto.login.LoginResponseDto;

public interface IAuthService {
    LoginResponseDto authenticate(LoginRequestDto loginRequest);
}
