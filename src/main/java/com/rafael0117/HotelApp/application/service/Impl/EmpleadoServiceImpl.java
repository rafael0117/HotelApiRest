package com.rafael0117.HotelApp.application.service.Impl;

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
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IEmpleadoService;
import com.rafael0117.HotelApp.domain.entity.*;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;
    @Override
    public List<EmpleadoResponseDto> listar() {
        return repository.findAll().stream().map(mapper::getDtoEmpleado).toList();
    }

    @Override
    public AdministradorResponseDto guardarAdministrador(AdministradorRequestDto dto) {
        Administrador admin = mapper.getEntityAdministrador(dto);
        Administrador guardado = repository.save(admin);
        return mapper.getDtoAdministrador(guardado);
    }

    @Override
    public CocineroResponseDto guardarCocinero(CocineroRequestDto dto) {
        Cocinero cocinero = mapper.getEntityCocinero(dto);
        Cocinero guardado = repository.save(cocinero);
        return mapper.getDtoCocinero(guardado);
    }

    @Override
    public MantenimientoResponseDto guardarMantenimiento(MantenimientoRequestDto dto) {
        Mantenimiento mantenimiento = mapper.getEntityMantenimiento(dto);
        Mantenimiento guardado = repository.save(mantenimiento);
        return mapper.getDtoMantenimiento(guardado);
    }

    @Override
    public PersonalLimpiezaResponseDto guardarPersonalLimpieza(PersonalLimpiezaRequestDto dto) {
        PersonalLimpieza limpieza = mapper.getEntityPersonalLimpieza(dto);
        PersonalLimpieza guardado = repository.save(limpieza);
        return mapper.getDtoPersonalLimpieza(guardado);
    }

    @Override
    public RecepcionistaResponseDto guardarRecepcionista(RecepcionistaRequestDto dto) {
        Recepcionista recepcionista = mapper.getEntityRecepcionista(dto);
        Recepcionista guardado = repository.save(recepcionista);
        return mapper.getDtoRecepcionista(guardado);
    }

    @Override
    public AdministradorResponseDto editarAdministrador(Long id, AdministradorRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el administrador con ID: " + id));
        Administrador admin = mapper.getEntityAdministrador(dto);
        admin.setId(id);
        Administrador actualizado = repository.save(admin);
        return mapper.getDtoAdministrador(actualizado);
    }

    @Override
    public CocineroResponseDto editarCocinero(Long id, CocineroRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el cocinero con ID: " + id));
        Cocinero cocinero = mapper.getEntityCocinero(dto);
        cocinero.setId(id);
        Cocinero actualizado = repository.save(cocinero);
        return mapper.getDtoCocinero(actualizado);
    }

    @Override
    public MantenimientoResponseDto editarMantenimiento(Long id, MantenimientoRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró mantenimiento con ID: " + id));
        Mantenimiento mantenimiento = mapper.getEntityMantenimiento(dto);
        mantenimiento.setId(id);
        Mantenimiento actualizado = repository.save(mantenimiento);
        return mapper.getDtoMantenimiento(actualizado);
    }

    @Override
    public PersonalLimpiezaResponseDto editarPersonalLimpieza(Long id, PersonalLimpiezaRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró personal de limpieza con ID: " + id));
        PersonalLimpieza limpieza = mapper.getEntityPersonalLimpieza(dto);
        limpieza.setId(id);
        PersonalLimpieza actualizado = repository.save(limpieza);
        return mapper.getDtoPersonalLimpieza(actualizado);
    }

    @Override
    public RecepcionistaResponseDto editarRecepcionistar(Long id, RecepcionistaRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró recepcionista con ID: " + id));
        Recepcionista recepcionista = mapper.getEntityRecepcionista(dto);
        recepcionista.setId(id);
        Recepcionista actualizado = repository.save(recepcionista);
        return mapper.getDtoRecepcionista(actualizado);
    }


    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el id:"+id);
        }
        repository.deleteById(id);
    }

    @Override
    public EmpleadoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::getDtoEmpleado)
                .orElseThrow(() -> new RuntimeException("No existe el Bus con ID : " + id));
    }
}
