package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.login.LoginRequestDto;
import com.rafael0117.HotelApp.application.dto.login.LoginResponseDto;
import com.rafael0117.HotelApp.application.service.IAuthService;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import com.rafael0117.HotelApp.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final IEmpleadoRepository empleadoRepository;
    private final JwtUtil jwtUtil;
    @Override
    public LoginResponseDto authenticate(LoginRequestDto loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsuario(),
                        loginRequest.getPassword()
                )
        );
        UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsuario());
        String token = jwtUtil.generateToken(user);
        long expiration = jwtUtil.extractExpiration(token).getTime();

        return LoginResponseDto.builder()
                .token(token)
                .username(user.getUsername())
                .cargos(user.getAuthorities().stream()
                        .map(c -> c.getAuthority())
                        .toList())
                .expirateAt(expiration)
                .build();
    }
}
