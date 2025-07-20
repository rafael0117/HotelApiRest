package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.service.ICocineroService;
import com.rafael0117.HotelApp.application.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cocinero")
public class CocineroController {
    private final ICocineroService service;
    @GetMapping
    public ResponseEntity<List<CocineroResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @PostMapping
    public CocineroResponseDto guardarCocinero(@RequestBody CocineroRequestDto dto) {
        return service.guardarCocinero(dto);
    }
    @PutMapping("/{id}")
    public CocineroResponseDto editarCocinero(@PathVariable Long id, @RequestBody CocineroRequestDto dto) {
        return service.editarCocinero(id, dto);
    }
    // ✅ Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<CocineroResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
