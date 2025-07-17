package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.login.LoginRequestDto;
import com.rafael0117.HotelApp.application.dto.login.LoginResponseDto;
import com.rafael0117.HotelApp.application.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService service;
    @PostMapping("/login")
    LoginResponseDto authenticate(@RequestBody LoginRequestDto loginRequest){
        return service.authenticate(loginRequest);
    }
    @PostMapping("/register")
    AdministradorResponseDto register(@RequestBody AdministradorRequestDto request){
        return service.register(request);
    }
}
