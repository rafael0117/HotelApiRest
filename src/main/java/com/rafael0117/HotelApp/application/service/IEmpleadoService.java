package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoResponseDto> listar();

    CocineroResponseDto guardarCocinero(CocineroRequestDto dto);
    com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto guardarMantenimiento(com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto dto);
    PersonalLimpiezaResponseDto guardarPersonalLimpieza(PersonalLimpiezaRequestDto dto);
    RecepcionistaResponseDto guardarRecepcionista(RecepcionistaRequestDto dto);

   CocineroResponseDto editarCocinero(Long Id, CocineroRequestDto dto);
    PersonalLimpiezaResponseDto editarPersonalLimpieza(Long Id,PersonalLimpiezaRequestDto dto);
    RecepcionistaResponseDto editarRecepcionistar(Long Id,RecepcionistaRequestDto dto);
    void eliminar(Long id);

}
