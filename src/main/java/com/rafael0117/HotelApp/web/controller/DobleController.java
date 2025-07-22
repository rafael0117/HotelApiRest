package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;
import com.rafael0117.HotelApp.application.service.IDobleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doble")
public class DobleController {
    private final IDobleService service;
    @GetMapping
    List<DobleResponseDto> listar(){
        return service.listar();
    }
    @PostMapping
    DobleResponseDto guardar(@RequestBody DobleRequestDto dto){
        return service.guardar(dto);
    }
    @PutMapping("/{id}")
    DobleResponseDto editar(@PathVariable Long id,@RequestBody DobleRequestDto dto){
        return service.editar(id,dto);
    }
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
    @GetMapping("/{id}")
    DobleResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}
