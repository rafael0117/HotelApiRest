package com.rafael0117.HotelApp.application.mapper;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;
import com.rafael0117.HotelApp.domain.entity.*;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {
    public EmpleadoResponseDto getDtoEmpleado(Empleado empleado) {
        EmpleadoResponseDto.EmpleadoResponseDtoBuilder builder = EmpleadoResponseDto.builder()
                .id(empleado.getId())
                .nombre(empleado.getNombre())
                .dni(empleado.getDni())
                .telefono(empleado.getTelefono())
                .salario(empleado.getSalario())
                .usuario(empleado.getUsuario())
                .password(empleado.getPassword())
                .cargos(empleado.getCargos())
                .fechaIngreso(empleado.getFechaIngreso());

        if (empleado instanceof Administrador admin) {
            builder.nivelAcceso(admin.getNivelAcceso());
        } else if (empleado instanceof Cocinero cocinero) {
            builder.especialidad(cocinero.getEspecialidad());
        } else if (empleado instanceof Mantenimiento mant) {
            builder.disponible(mant.isDisponible())
                    .areaResponsable(mant.getAreaResponsable());
        } else if (empleado instanceof PersonalLimpieza limpieza) {
            builder.pisosAsignados(limpieza.getPisosAsignados());
        } else if (empleado instanceof Recepcionista recep) {
            builder.turno(recep.getTurno());
        }

        return builder.build();
    }
    public AdministradorResponseDto getDtoAdministrador(Administrador admin){
        return AdministradorResponseDto.builder()
                .id(admin.getId())
                .nombre(admin.getNombre())
                .dni(admin.getDni())
                .telefono(admin.getTelefono())
                .salario(admin.getSalario())
                .usuario(admin.getUsuario())
                .password(admin.getPassword())
                .cargos(admin.getCargos())
                .fechaIngreso(admin.getFechaIngreso())
                .nivelAcceso(admin.getNivelAcceso())
                .build();
    }
    public CocineroResponseDto getDtoCocinero(Cocinero cocinero){
        return CocineroResponseDto.builder()
                .id(cocinero.getId())
                .nombre(cocinero.getNombre())
                .dni(cocinero.getDni())
                .telefono(cocinero.getTelefono())
                .salario(cocinero.getSalario())
                .usuario(cocinero.getUsuario())
                .password(cocinero.getPassword())
                .cargos(cocinero.getCargos())
                .fechaIngreso(cocinero.getFechaIngreso())
                .especialidad(cocinero.getEspecialidad())
                .build();
    }
    public MantenimientoResponseDto getDtoMantenimiento(Mantenimiento mantenimiento){
        return MantenimientoResponseDto.builder()
                .id(mantenimiento.getId())
                .nombre(mantenimiento.getNombre())
                .dni(mantenimiento.getDni())
                .telefono(mantenimiento.getTelefono())
                .salario(mantenimiento.getSalario())
                .usuario(mantenimiento.getUsuario())
                .password(mantenimiento.getPassword())
                .cargos(mantenimiento.getCargos())
                .fechaIngreso(mantenimiento.getFechaIngreso())
                .disponible(mantenimiento.isDisponible())
                .areaResponsable(mantenimiento.getAreaResponsable())
                .build();
    }
    public PersonalLimpiezaResponseDto getDtoPersonalLimpieza(PersonalLimpieza limpieza){
        return PersonalLimpiezaResponseDto.builder()
                .id(limpieza.getId())
                .nombre(limpieza.getNombre())
                .dni(limpieza.getDni())
                .telefono(limpieza.getTelefono())
                .salario(limpieza.getSalario())
                .usuario(limpieza.getUsuario())
                .password(limpieza.getPassword())
                .cargos(limpieza.getCargos())
                .fechaIngreso(limpieza.getFechaIngreso())
                .pisosAsignados(limpieza.getPisosAsignados())
                .build();
    }
    public RecepcionistaResponseDto getDtoRecepcionista(Recepcionista recepcionista){
        return RecepcionistaResponseDto.builder()
                .id(recepcionista.getId())
                .nombre(recepcionista.getNombre())
                .dni(recepcionista.getDni())
                .telefono(recepcionista.getTelefono())
                .salario(recepcionista.getSalario())
                .usuario(recepcionista.getUsuario())
                .password(recepcionista.getPassword())
                .cargos(recepcionista.getCargos())
                .fechaIngreso(recepcionista.getFechaIngreso())
                .turno(recepcionista.getTurno())
                .build();
    }

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
