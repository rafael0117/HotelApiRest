package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
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
@RequestMapping("/api/empleado")
public class EmpleadoController {
    private final IEmpleadoService empleadoService;
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> listar() {
        return ResponseEntity.ok(empleadoService.listar());
    }


    @PostMapping("/administrador")
    public AdministradorResponseDto guardarAdministrador(@RequestBody AdministradorRequestDto dto) {
        return empleadoService.guardarAdministrador(dto);
    }

    @PostMapping("/cocinero")
    public CocineroResponseDto guardarCocinero(@RequestBody CocineroRequestDto dto) {
        return empleadoService.guardarCocinero(dto);
    }

    @PostMapping("/mantenimiento")
    public MantenimientoResponseDto guardarMantenimiento(@RequestBody MantenimientoRequestDto dto) {
        return empleadoService.guardarMantenimiento(dto);
    }

    @PostMapping("/personalLimpieza")
    public PersonalLimpiezaResponseDto guardarPersonalLimpieza(@RequestBody PersonalLimpiezaRequestDto dto) {
        return empleadoService.guardarPersonalLimpieza(dto);
    }

    @PostMapping("/recepcionista")
    public RecepcionistaResponseDto guardarRecepcionista(@RequestBody RecepcionistaRequestDto dto) {
        return empleadoService.guardarRecepcionista(dto);
    }

    //Editar Empleado
    @PutMapping("/administrador/{id}")
    public AdministradorResponseDto editarAdministrador(@PathVariable Long id, @RequestBody AdministradorRequestDto dto) {
        return empleadoService.editarAdministrador(id, dto);
    }

    @PutMapping("/cocinero/{id}")
    public CocineroResponseDto editarCocinero(@PathVariable Long id, @RequestBody CocineroRequestDto dto) {
        return empleadoService.editarCocinero(id, dto);
    }

    @PutMapping("/mantenimiento/{id}")
    public MantenimientoResponseDto editarMantenimiento(@PathVariable Long id, @RequestBody MantenimientoRequestDto dto) {
        return empleadoService.editarMantenimiento(id, dto);
    }

    @PutMapping("/personalLimpieza/{id}")
    public PersonalLimpiezaResponseDto editarPersonalLimpieza(@PathVariable Long id, @RequestBody PersonalLimpiezaRequestDto dto) {
        return empleadoService.editarPersonalLimpieza(id, dto);
    }

    @PutMapping("/recepcionista/{id}")
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
