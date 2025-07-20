package com.rafael0117.HotelApp.web.controller;

import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
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






    @PostMapping("/personalLimpieza")
    public PersonalLimpiezaResponseDto guardarPersonalLimpieza(@RequestBody PersonalLimpiezaRequestDto dto) {
        return empleadoService.guardarPersonalLimpieza(dto);
    }

    @PostMapping("/recepcionista")
    public RecepcionistaResponseDto guardarRecepcionista(@RequestBody RecepcionistaRequestDto dto) {
        return empleadoService.guardarRecepcionista(dto);
    }




    @PutMapping("/mantenimiento/{id}")
    public CocineroResponseDto editarMantenimiento(@PathVariable Long id, @RequestBody MantenimientoRequestDto dto) {
        return null;//empleadoService.editarMantenimiento(id, dto);
    }

    @PutMapping("/personalLimpieza/{id}")
    public PersonalLimpiezaResponseDto editarPersonalLimpieza(@PathVariable Long id, @RequestBody PersonalLimpiezaRequestDto dto) {
        return empleadoService.editarPersonalLimpieza(id, dto);
    }


}
