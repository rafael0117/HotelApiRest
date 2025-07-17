package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.login.LoginRequestDto;
import com.rafael0117.HotelApp.application.dto.login.LoginResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IAuthService;
import com.rafael0117.HotelApp.domain.entity.Administrador;
import com.rafael0117.HotelApp.domain.enums.Cargo;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import com.rafael0117.HotelApp.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final IEmpleadoRepository empleadoRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmpleadoMapper mapper;

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
    @Override
    public AdministradorResponseDto register(AdministradorRequestDto request) {
        if (empleadoRepository.existsByUsuario(request.getUsuario())) {
            throw new RuntimeException("El usuario ya existe");
        }

        // Crear un nuevo Administrador
        Administrador administrador = Administrador.builder()
                .usuario(request.getUsuario())
                .password(passwordEncoder.encode(request.getPassword()))
                .nombre(request.getNombre())
                .dni(request.getDni())
                .telefono(request.getTelefono())
                .salario(request.getSalario())
                .nivelAcceso(request.getNivelAcceso()) // Puedes personalizar esto
                .cargos(Set.of(Cargo.ADMINISTRADOR)) // Asignar el cargo enum
                .fechaIngreso(LocalDate.now())
                .build();

        empleadoRepository.save(administrador);
        return mapper.getDtoAdministrador(administrador);
    }

}
