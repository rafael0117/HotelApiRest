package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.reserva.ReservaRequestDto;
import com.rafael0117.HotelApp.application.dto.reserva.ReservaResponseDto;
import com.rafael0117.HotelApp.application.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reserva")
public class ReservaController {
    private final IReservaService service;

    @GetMapping
    List<ReservaResponseDto> listar(){
        return service.listar();
    }
    @PostMapping
    ReservaResponseDto guardar(@RequestBody ReservaRequestDto dto){
        return service.guardar(dto);
    }
    @PutMapping("/{id}")
    ReservaResponseDto editar(@PathVariable Long id,@RequestBody ReservaRequestDto dto){
        return service.editar(id,dto);
    }
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    @GetMapping("/{id}")
    ReservaResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

}
