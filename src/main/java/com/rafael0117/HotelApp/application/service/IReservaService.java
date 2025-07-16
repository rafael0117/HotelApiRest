package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.reserva.ReservaRequestDto;
import com.rafael0117.HotelApp.application.dto.reserva.ReservaResponseDto;

import java.util.List;

public interface IReservaService {
    List<ReservaResponseDto> listar();
    ReservaResponseDto guardar(ReservaRequestDto dto);
    ReservaResponseDto editar(Long id,ReservaRequestDto dto);
    void eliminar(Long id);
    ReservaResponseDto buscarPorId(Long id);
}
