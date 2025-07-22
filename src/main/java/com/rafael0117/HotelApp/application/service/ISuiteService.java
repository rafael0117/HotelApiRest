package com.rafael0117.HotelApp.application.service;


import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;

import java.util.List;

public interface ISuiteService {
    List<SuiteResponseDto> listar();
    SuiteResponseDto guardar(SuiteRequestDto dto);
    SuiteResponseDto editar(Long id,SuiteRequestDto dto);
    void eliminar(Long id);
    SuiteResponseDto buscarPorId(Long id);
}
