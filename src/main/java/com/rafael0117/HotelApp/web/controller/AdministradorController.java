package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.service.IAdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/administrador")
public class AdministradorController {
    private final IAdministradorService service;
    @GetMapping
    public ResponseEntity<List<AdministradorResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }


    @PostMapping
    public AdministradorResponseDto guardarAdministrador(@RequestBody AdministradorRequestDto dto) {
        return service.guardarAdministrador(dto);
    }

    //Editar Empleado
    @PutMapping("/{id}")
    public AdministradorResponseDto editarAdministrador(@PathVariable Long id, @RequestBody AdministradorRequestDto dto) {
        return service.editarAdministrador(id, dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Buscar empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<AdministradorResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
