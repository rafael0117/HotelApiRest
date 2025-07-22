package com.rafael0117.HotelApp.application.service;


import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;

import java.util.List;

public interface IIndividualService {
    List<IndividualResponseDto> listar();
    IndividualResponseDto guardar(IndividualRequestDto dto);
    IndividualResponseDto editar(Long id,IndividualRequestDto dto);
    void eliminar(Long id);
    IndividualResponseDto buscarPorId(Long id);
}
