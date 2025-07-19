package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import com.rafael0117.HotelApp.application.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {
    private final IEmpleadoService empleadoService;
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> listar() {
        return ResponseEntity.ok(empleadoService.listar());
    }
    @PostMapping
    public MantenimientoResponseDto guardarMantenimiento(@RequestBody MantenimientoRequestDto dto) {
        return empleadoService.guardarMantenimiento(dto);
    }
    @PutMapping("/{id}")
    public MantenimientoResponseDto editarMantenimiento(@PathVariable Long id, @RequestBody MantenimientoRequestDto dto) {
        return empleadoService.editarMantenimiento(id, dto);
    }
    // ✅ Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.buscarPorId(id));
    }

}
