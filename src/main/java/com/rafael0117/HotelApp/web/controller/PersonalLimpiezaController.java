package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.service.IPersonalLimpiezaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/limpieza")
public class PersonalLimpiezaController {
    private final IPersonalLimpiezaService service;
    @GetMapping
    public ResponseEntity<List<PersonalLimpiezaResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }


    @PostMapping
    public PersonalLimpiezaResponseDto guardarPersonalLimpieza(@RequestBody PersonalLimpiezaRequestDto dto) {
        return service.guardarPersonalLimpieza(dto);
    }


    @PutMapping("/{id}")
    public PersonalLimpiezaResponseDto editarPersonalLimpieza(@PathVariable Long id, @RequestBody PersonalLimpiezaRequestDto dto) {
        return service.editarPersonalLimpieza(id, dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonalLimpiezaResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}
