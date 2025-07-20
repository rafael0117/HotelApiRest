package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;

import java.util.List;

public interface IAdministradorService {
    List<AdministradorResponseDto> listar();
    AdministradorResponseDto guardarAdministrador(AdministradorRequestDto dto);
    AdministradorResponseDto editarAdministrador(Long Id,AdministradorRequestDto dto);
    AdministradorResponseDto buscarPorId(Long id);
    void eliminar(Long id);
}
