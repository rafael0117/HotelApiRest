package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;
import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionResponseDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;
import com.rafael0117.HotelApp.application.service.IHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/habitacion")
public class HabitacionController {
    private IHabitacionService service;

    @GetMapping
    List<HabitacionResponseDto> listar(){
        return service.listar();
    }
    @PostMapping("/doble")
    DobleResponseDto guardarDoble(@RequestBody DobleRequestDto dto){
        return service.guardarDoble(dto);
    }
    @PostMapping("/individual")
    IndividualResponseDto guardarIndividual(@RequestBody IndividualRequestDto dto){
        return service.guardarIndividual(dto);
    }
    @PostMapping("/suite")
    SuiteResponseDto guardarSuite(@RequestBody SuiteRequestDto dto){
        return service.guardarSuite(dto);
    }
    @PutMapping("/doble/{id}")
    DobleResponseDto editarDoble(@PathVariable Long id,@RequestBody DobleRequestDto dto){
        return service.editarDoble(id,dto);
    }
    @PutMapping("/individual/{id}")
    IndividualResponseDto editarIndividual(@PathVariable Long id,@RequestBody IndividualRequestDto dto){
        return service.editarIndividual(id,dto);
    }
    @PutMapping("/suite/{id}")
    SuiteResponseDto editarSuite(@PathVariable Long id,@RequestBody SuiteRequestDto dto){
        return service.editarSuite(id,dto);
    }
    @DeleteMapping
    void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    @GetMapping("/{id}")
    HabitacionResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}
