package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;

import java.util.List;

public interface IDobleService {
    List<DobleResponseDto> listar();
    DobleResponseDto guardar(DobleRequestDto dto);
    DobleResponseDto editar(Long id,DobleRequestDto dto);
    void eliminar(Long id);
    DobleResponseDto buscarPorId(Long id);
}
