package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;
import com.rafael0117.HotelApp.application.mapper.HabitacionMapper;
import com.rafael0117.HotelApp.application.service.IIndividualService;
import com.rafael0117.HotelApp.domain.entity.Doble;
import com.rafael0117.HotelApp.domain.entity.Individual;
import com.rafael0117.HotelApp.domain.repository.IHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IIndividualService {
    private final IHabitacionRepository repository;
    private final HabitacionMapper mapper;
    @Override
    public List<IndividualResponseDto> listar() {
        return repository.findAll().stream()
                .filter(h -> h instanceof Individual)
                .map(h -> mapper.getDtoIndividual((Individual) h)).toList();
    }

    @Override
    public IndividualResponseDto guardar(IndividualRequestDto dto) {
        Individual individual = mapper.getEntityIndividual(dto);
        Individual individualGuardado = repository.save(individual);
        return mapper.getDtoIndividual(individualGuardado);
    }

    @Override
    public IndividualResponseDto editar(Long id, IndividualRequestDto dto) {
        repository.findById(id).orElseThrow();
        Individual individual= mapper.getEntityIndividual(dto);
        individual.setId(id);
        Individual individualActualizado = repository.save(individual);
        return mapper.getDtoIndividual(individualActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el id");
        }
        repository.deleteById(id);
    }

    @Override
    public IndividualResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(h -> mapper.getDtoIndividual((Individual) h))
                .orElseThrow(() -> new RuntimeException("No existe el Cocinero con ID: " + id));
    }
}
