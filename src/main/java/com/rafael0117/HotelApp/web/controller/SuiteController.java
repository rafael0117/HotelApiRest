package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;
import com.rafael0117.HotelApp.application.service.ISuiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suite")
public class SuiteController {
    private final ISuiteService service;
    @GetMapping
    List<SuiteResponseDto> listar(){
        return service.listar();
    }
    @PostMapping
    SuiteResponseDto guardar(@RequestBody SuiteRequestDto dto){
        return service.guardar(dto);
    }
    @PutMapping("/{id}")
    SuiteResponseDto editar(@PathVariable Long id,@RequestBody SuiteRequestDto dto){
        return service.editar(id,dto);
    }
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    @GetMapping("/{id}")
    SuiteResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}
