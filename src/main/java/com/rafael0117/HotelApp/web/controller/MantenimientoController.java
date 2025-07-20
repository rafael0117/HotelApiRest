package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.service.IMantenimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {
    private final IMantenimientoService service;
    @GetMapping
    public ResponseEntity<List<MantenimientoResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @PostMapping
    public MantenimientoResponseDto guardarMantenimiento(@RequestBody MantenimientoRequestDto dto) {
        return service.guardarMantenimiento(dto);
    }
    @PutMapping("/{id}")
    public MantenimientoResponseDto editarMantenimiento(@PathVariable Long id, @RequestBody MantenimientoRequestDto dto) {
        return service.editarMantenimiento(id, dto);
    }

    // ✅ Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}
