package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;

import java.util.List;

public interface IPersonalLimpiezaService {
    List<PersonalLimpiezaResponseDto> listar();
    PersonalLimpiezaResponseDto guardarPersonalLimpieza(PersonalLimpiezaRequestDto dto);
    PersonalLimpiezaResponseDto editarPersonalLimpieza(Long Id, PersonalLimpiezaRequestDto dto);
    PersonalLimpiezaResponseDto buscarPorId(Long id);
    void eliminar(Long id);
}
