package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionResponseDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;
import com.rafael0117.HotelApp.application.mapper.HabitacionMapper;
import com.rafael0117.HotelApp.application.service.IHabitacionService;
import com.rafael0117.HotelApp.domain.entity.Doble;
import com.rafael0117.HotelApp.domain.entity.Habitacion;
import com.rafael0117.HotelApp.domain.entity.Individual;
import com.rafael0117.HotelApp.domain.entity.Suite;
import com.rafael0117.HotelApp.domain.repository.IHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements IHabitacionService {
    private final IHabitacionRepository repository;
    private final HabitacionMapper mapper;
    @Override
    public List<HabitacionResponseDto> listar() {
        return repository.findAll().stream().map(mapper::getDtoHabitacion).toList();
    }

    @Override
    public DobleResponseDto guardarDoble(DobleRequestDto dto) {
        Doble doble = mapper.getEntityDoble(dto);
        Doble dobleGuardado = repository.save(doble);
        return mapper.getDtoDoble(dobleGuardado);
    }

    @Override
    public IndividualResponseDto guardarIndividual(IndividualRequestDto dto) {
        Individual individual = mapper.getEntityIndividual(dto);
        Individual individualGuardado = repository.save(individual);
        return mapper.getDtoIndividual(individualGuardado);
    }

    @Override
    public SuiteResponseDto guardarSuite(SuiteRequestDto dto) {
        Suite suite = mapper.getEntitySuite(dto);
        Suite suiteGuardado = repository.save(suite);
        return mapper.getDtoSuite(suiteGuardado);
    }

    @Override
    public DobleResponseDto editarDoble(Long id, DobleRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id"));
        Doble doble = mapper.getEntityDoble(dto);
        doble.setId(id);
        Doble dobleActualizado = repository.save(doble);
        return mapper.getDtoDoble(dobleActualizado);
    }

    @Override
    public IndividualResponseDto editarIndividual(Long id, IndividualRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id"));
        Individual individual = mapper.getEntityIndividual(dto);
        individual.setId(id);
        Individual individualActualizado = repository.save(individual);
        return mapper.getDtoIndividual(individualActualizado);
    }

    @Override
    public SuiteResponseDto editarSuite(Long id, SuiteRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id"));
        Suite suite = mapper.getEntitySuite(dto);
        suite.setId(id);
        Suite suiteActualizado = repository.save(suite);
        return mapper.getDtoSuite(suiteActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el id:"+id);
        }
        repository.deleteById(id);
    }

    @Override
    public HabitacionResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::getDtoHabitacion)
                .orElseThrow(() -> new RuntimeException("No existe el Bus con ID : " + id));
    }
}
