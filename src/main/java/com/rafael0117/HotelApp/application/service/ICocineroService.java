package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;

import java.util.List;

public interface ICocineroService {
    List<CocineroResponseDto> listar();
    CocineroResponseDto guardarCocinero(CocineroRequestDto dto);
    CocineroResponseDto editarCocinero(Long Id, CocineroRequestDto dto);
    CocineroResponseDto buscarPorId(Long id);
    void eliminar(Long id);
}
