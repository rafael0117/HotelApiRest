package com.rafael0117.HotelApp.application.service;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;
import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionResponseDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;

import java.util.List;

public interface IHabitacionService {
    List<HabitacionResponseDto> listar();
    DobleResponseDto guardarDoble(DobleRequestDto dto);
    IndividualResponseDto guardarIndividual(IndividualRequestDto dto);
    SuiteResponseDto guardarSuite(SuiteRequestDto dto);
    DobleResponseDto editarDoble(Long id,DobleRequestDto dto);
    IndividualResponseDto editarIndividual(Long id,IndividualRequestDto dto);
    SuiteResponseDto editarSuite(Long id,SuiteRequestDto dto);
    void eliminar(Long id);
    HabitacionResponseDto buscarPorId(Long id);
}
