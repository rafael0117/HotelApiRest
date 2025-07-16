package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.huesped.HuespedRequestDto;
import com.rafael0117.HotelApp.application.dto.huesped.HuespedResponseDto;
import com.rafael0117.HotelApp.application.service.IHuespedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/huesped")
@RequiredArgsConstructor
public class HuespedController {
    private final IHuespedService service;

    @GetMapping
    List<HuespedResponseDto> listar(){
        return service.listar();
    }
    @PostMapping
    HuespedResponseDto guardar(@RequestBody HuespedRequestDto dto){
        return service.guardar(dto);
    }
    @PutMapping("/{id}")
    HuespedResponseDto editar(@PathVariable Long id,@RequestBody HuespedRequestDto dto){
        return service.editar(id,dto);
    }
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    @GetMapping("/{id}")
    HuespedResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}
