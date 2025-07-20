package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaRequestDto;
import com.rafael0117.HotelApp.application.dto.recepcionista.RecepcionistaResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IRecepcionistaService;
import com.rafael0117.HotelApp.domain.entity.Recepcionista;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecepcionistaServiceImpl implements IRecepcionistaService {

    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    @Override
    public List<RecepcionistaResponseDto> listar() {
        return repository.findAll().stream()
                .filter(e -> e instanceof Recepcionista)
                .map(e -> mapper.getDtoRecepcionista((Recepcionista) e))
                .toList();
    }

    @Override
    public RecepcionistaResponseDto guardarRecepcionista(RecepcionistaRequestDto dto) {
        Recepcionista recepcionista = mapper.getEntityRecepcionista(dto);
        Recepcionista guardado = repository.save(recepcionista);
        return mapper.getDtoRecepcionista(guardado);
    }

    @Override
    public RecepcionistaResponseDto editarRecepcionista(Long id, RecepcionistaRequestDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el recepcionista con ID: " + id));
        Recepcionista actualizado = mapper.getEntityRecepcionista(dto);
        actualizado.setId(id);
        Recepcionista guardado = repository.save(actualizado);
        return mapper.getDtoRecepcionista(guardado);
    }

    @Override
    public RecepcionistaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(e -> mapper.getDtoRecepcionista((Recepcionista) e))
                .orElseThrow(() -> new RuntimeException("No existe el recepcionista con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe el id: " + id);
        }
        repository.deleteById(id);
    }
}
