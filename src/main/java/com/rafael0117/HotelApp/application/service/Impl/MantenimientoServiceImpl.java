package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoRequestDto;
import com.rafael0117.HotelApp.application.dto.mantenimiento.MantenimientoResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IMantenimientoService;
import com.rafael0117.HotelApp.domain.entity.Mantenimiento;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MantenimientoServiceImpl implements IMantenimientoService {

    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    @Override
    public List<MantenimientoResponseDto> listar() {
        return repository.findAll().stream()
                .filter(e -> e instanceof Mantenimiento)
                .map(e -> mapper.getDtoMantenimiento((Mantenimiento) e))
                .toList();
    }



    @Override
    public MantenimientoResponseDto guardarMantenimiento(MantenimientoRequestDto dto) {
        Mantenimiento mantenimiento = mapper.getEntityMantenimiento(dto);
        Mantenimiento guardado = repository.save(mantenimiento);
        return mapper.getDtoMantenimiento(guardado);
    }

    @Override
    public MantenimientoResponseDto editarMantenimiento(Long id, MantenimientoRequestDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el Mantenimiento con ID: " + id));
        Mantenimiento actualizado = mapper.getEntityMantenimiento(dto);
        actualizado.setId(id);
        Mantenimiento guardado = repository.save(actualizado);
        return mapper.getDtoMantenimiento(guardado);
    }

    @Override
    public MantenimientoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(e -> mapper.getDtoMantenimiento((Mantenimiento) e))
                .orElseThrow(() -> new RuntimeException("No existe el Mantenimiento con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe el id: " + id);
        }
        repository.deleteById(id);
    }
}
