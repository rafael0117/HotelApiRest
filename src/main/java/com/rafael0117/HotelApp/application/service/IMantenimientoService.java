package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import java.util.List;

public interface IMantenimientoService{
    List<MantenimientoResponseDto> listar();
    MantenimientoResponseDto guardarMantenimiento(MantenimientoRequestDto dto);
    MantenimientoResponseDto editarMantenimiento(Long Id, MantenimientoRequestDto dto);
    MantenimientoResponseDto buscarPorId(Long id);
    void eliminar(Long id);
}
