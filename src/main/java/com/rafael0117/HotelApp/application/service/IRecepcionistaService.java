package com.rafael0117.HotelApp.application.service;



import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;

import java.util.List;

public interface IRecepcionistaService {
    List<RecepcionistaResponseDto> listar();
    RecepcionistaResponseDto guardarRecepcionista(RecepcionistaRequestDto dto);
    RecepcionistaResponseDto editarRecepcionista(Long Id, RecepcionistaRequestDto dto);
    RecepcionistaResponseDto buscarPorId(Long id);
    void eliminar(Long id);
}
