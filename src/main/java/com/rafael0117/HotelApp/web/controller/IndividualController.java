package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;
import com.rafael0117.HotelApp.application.service.IIndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/individual")
public class IndividualController {
    private final IIndividualService service;
    @GetMapping
    List<IndividualResponseDto> listar(){
        return service.listar();
    }
    @PostMapping
    IndividualResponseDto guardar(@RequestBody IndividualRequestDto dto){
        return service.guardar(dto);
    }
    @PutMapping("/{id}")
    IndividualResponseDto editar(@PathVariable Long id,@RequestBody IndividualRequestDto dto){
        return service.editar(id,dto);
    }
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    @GetMapping("/{id}")
    IndividualResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}
