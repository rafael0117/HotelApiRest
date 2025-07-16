package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.huesped.HuespedRequestDto;
import com.rafael0117.HotelApp.application.dto.huesped.HuespedResponseDto;

import java.util.List;

public interface IHuespedService {
    List<HuespedResponseDto> listar();
    HuespedResponseDto guardar(HuespedRequestDto dto);
    HuespedResponseDto editar(Long id,HuespedRequestDto dto);
    void eliminar(Long id);
    HuespedResponseDto buscarPorId(Long id);
}
