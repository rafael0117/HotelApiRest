package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;
import com.rafael0117.HotelApp.application.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recepcionista")
public class RecepcionistaController {
    private final IEmpleadoService empleadoService;
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> listar() {
        return ResponseEntity.ok(empleadoService.listar());
    }


    @PostMapping
    public RecepcionistaResponseDto guardarRecepcionista(@RequestBody RecepcionistaRequestDto dto) {
        return empleadoService.guardarRecepcionista(dto);
    }
    @PutMapping("/{id}")
    public RecepcionistaResponseDto editarRecepcionista(@PathVariable Long id, @RequestBody RecepcionistaRequestDto dto) {
        return empleadoService.editarRecepcionistar(id, dto);
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
