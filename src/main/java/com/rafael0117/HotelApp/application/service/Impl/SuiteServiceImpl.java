package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;
import com.rafael0117.HotelApp.application.mapper.HabitacionMapper;
import com.rafael0117.HotelApp.application.service.ISuiteService;
import com.rafael0117.HotelApp.domain.entity.Doble;
import com.rafael0117.HotelApp.domain.entity.Suite;
import com.rafael0117.HotelApp.domain.repository.IHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuiteServiceImpl implements ISuiteService {
    private final IHabitacionRepository repository;
    private final HabitacionMapper mapper;
    @Override
    public List<SuiteResponseDto> listar() {
        return repository.findAll().stream()
                .filter(h -> h instanceof Suite)
                .map(h -> mapper.getDtoSuite((Suite) h)).toList();
    }

    @Override
    public SuiteResponseDto guardar(SuiteRequestDto dto) {
        Suite suite = mapper.getEntitySuite(dto);
        Suite suiteGuardado = repository.save(suite);
        return mapper.getDtoSuite(suiteGuardado);
    }

    @Override
    public SuiteResponseDto editar(Long id, SuiteRequestDto dto) {
        repository.findById(id).orElseThrow();
        Suite suite = mapper.getEntitySuite(dto);
        suite.setId(id);
        Suite suiteActualizado = repository.save(suite);
        return mapper.getDtoSuite(suiteActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el id");
        }
        repository.deleteById(id);
    }

    @Override
    public SuiteResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(h -> mapper.getDtoSuite((Suite) h))
                .orElseThrow(() -> new RuntimeException("No existe el Cocinero con ID: " + id));
    }
}
