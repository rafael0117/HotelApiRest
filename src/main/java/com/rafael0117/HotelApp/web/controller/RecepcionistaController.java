package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;
import com.rafael0117.HotelApp.application.service.IRecepcionistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recepcionista")
public class RecepcionistaController {
    private final IRecepcionistaService service;
    @GetMapping
    public ResponseEntity<List<RecepcionistaResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }


    @PostMapping
    public RecepcionistaResponseDto guardarRecepcionista(@RequestBody RecepcionistaRequestDto dto) {
        return service.guardarRecepcionista(dto);
    }
    @PutMapping("/{id}")
    public RecepcionistaResponseDto editarRecepcionista(@PathVariable Long id, @RequestBody RecepcionistaRequestDto dto) {
        return service.editarRecepcionista(id, dto);
    }


    // ✅ Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<RecepcionistaResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
