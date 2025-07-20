package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IEmpleadoService;
import com.rafael0117.HotelApp.domain.entity.*;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
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
    public CocineroResponseDto guardarCocinero(CocineroRequestDto dto) {
        Cocinero cocinero = mapper.getEntityCocinero(dto);
        Cocinero guardado = repository.save(cocinero);
        return mapper.getDtoCocinero(guardado);
    }

    @Override
    public com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto guardarMantenimiento(com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto dto) {
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
    public CocineroResponseDto editarCocinero(Long id, CocineroRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el cocinero con ID: " + id));
        Cocinero cocinero = mapper.getEntityCocinero(dto);
        cocinero.setId(id);
        Cocinero actualizado = repository.save(cocinero);
        return mapper.getDtoCocinero(actualizado);
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


}
