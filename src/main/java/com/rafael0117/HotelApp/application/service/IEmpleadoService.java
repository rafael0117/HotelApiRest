package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoResponseDto> listar();

    AdministradorResponseDto guardarAdministrador(AdministradorRequestDto dto);
    CocineroResponseDto guardarCocinero(CocineroRequestDto dto);
    MantenimientoResponseDto guardarMantenimiento(MantenimientoRequestDto dto);
    PersonalLimpiezaResponseDto guardarPersonalLimpieza(PersonalLimpiezaRequestDto dto);
    RecepcionistaResponseDto guardarRecepcionista(RecepcionistaRequestDto dto);

    AdministradorResponseDto editarAdministrador(Long Id,AdministradorRequestDto dto);
    CocineroResponseDto editarCocinero(Long Id,CocineroRequestDto dto);
    MantenimientoResponseDto editarMantenimiento(Long Id,MantenimientoRequestDto dto);
    PersonalLimpiezaResponseDto editarPersonalLimpieza(Long Id,PersonalLimpiezaRequestDto dto);
    RecepcionistaResponseDto editarRecepcionistar(Long Id,RecepcionistaRequestDto dto);
    void eliminar(Long id);
    EmpleadoResponseDto buscarPorId(Long id);

}
