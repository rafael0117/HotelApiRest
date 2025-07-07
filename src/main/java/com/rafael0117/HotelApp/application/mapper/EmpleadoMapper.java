package com.rafael0117.HotelApp.application.mapper;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.domain.entity.*;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {
    public Administrador getEntityAdministrador(AdministradorRequestDto requestDto){
        return Administrador.builder()
                .nombre(requestDto.getNombre())
                .dni(requestDto.getDni())
                .telefono(requestDto.getTelefono())
                .salario(requestDto.getSalario())
                .usuario(requestDto.getUsuario())
                .password(requestDto.getPassword())
                .cargos(requestDto.getCargos())
                .fechaIngreso(requestDto.getFechaIngreso())
                .nivelAcceso(requestDto.getNivelAcceso())
                .build();
    }
    public Cocinero getEntityCocinero(CocineroRequestDto requestDto){
        return Cocinero.builder()
                .nombre(requestDto.getNombre())
                .dni(requestDto.getDni())
                .telefono(requestDto.getTelefono())
                .salario(requestDto.getSalario())
                .usuario(requestDto.getUsuario())
                .password(requestDto.getPassword())
                .cargos(requestDto.getCargos())
                .fechaIngreso(requestDto.getFechaIngreso())
                .especialidad(requestDto.getEspecialidad())
                .build();
    }
    public Mantenimiento getEntityMantenimiento(MantenimientoRequestDto requestDto){
        return Mantenimiento.builder()
                .nombre(requestDto.getNombre())
                .dni(requestDto.getDni())
                .telefono(requestDto.getTelefono())
                .salario(requestDto.getSalario())
                .usuario(requestDto.getUsuario())
                .password(requestDto.getPassword())
                .cargos(requestDto.getCargos())
                .fechaIngreso(requestDto.getFechaIngreso())
                .disponible(requestDto.isDisponible())
                .areaResponsable(requestDto.getAreaResponsable())
                .build();
    }
    public PersonalLimpieza getEntityPersonalLimpieza(PersonalLimpiezaRequestDto requestDto){
        return PersonalLimpieza.builder()
                .nombre(requestDto.getNombre())
                .dni(requestDto.getDni())
                .telefono(requestDto.getTelefono())
                .salario(requestDto.getSalario())
                .usuario(requestDto.getUsuario())
                .password(requestDto.getPassword())
                .cargos(requestDto.getCargos())
                .fechaIngreso(requestDto.getFechaIngreso())
                .pisosAsignados(requestDto.getPisosAsignados())
                .build();
    }
    public Recepcionista getEntityRecepcionista(RecepcionistaRequestDto requestDto){
        return Recepcionista.builder()
                .nombre(requestDto.getNombre())
                .dni(requestDto.getDni())
                .telefono(requestDto.getTelefono())
                .salario(requestDto.getSalario())
                .usuario(requestDto.getUsuario())
                .password(requestDto.getPassword())
                .cargos(requestDto.getCargos())
                .fechaIngreso(requestDto.getFechaIngreso())
                .turno(requestDto.getTurno())
                .build();
    }
}
