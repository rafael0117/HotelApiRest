package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.cocinero.CocineroRequestDto;
import com.rafael0117.HotelApp.application.dto.cocinero.CocineroResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.ICocineroService;
import com.rafael0117.HotelApp.domain.entity.Cocinero;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CocineroServiceImpl implements ICocineroService {

    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    @Override
    public List<CocineroResponseDto> listar() {
        return repository.findAll().stream()
                .filter(e -> e instanceof Cocinero)
                .map(e -> mapper.getDtoCocinero((Cocinero) e))
                .toList();
    }

    @Override
    public CocineroResponseDto guardarCocinero(CocineroRequestDto dto) {
        Cocinero cocinero = mapper.getEntityCocinero(dto);
        Cocinero guardado = repository.save(cocinero);
        return mapper.getDtoCocinero(guardado);
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
    public CocineroResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(e -> mapper.getDtoCocinero((Cocinero) e))
                .orElseThrow(() -> new RuntimeException("No existe el Cocinero con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe el id: " + id);
        }
        repository.deleteById(id);
    }
}
