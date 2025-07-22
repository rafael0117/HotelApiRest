package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;
import com.rafael0117.HotelApp.application.mapper.HabitacionMapper;
import com.rafael0117.HotelApp.application.service.IDobleService;
import com.rafael0117.HotelApp.domain.entity.Cocinero;
import com.rafael0117.HotelApp.domain.entity.Doble;
import com.rafael0117.HotelApp.domain.repository.IHabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DobleServiceImpl implements IDobleService {
    private final IHabitacionRepository repository;
    private final HabitacionMapper mapper;
    @Override
    public List<DobleResponseDto> listar() {
        return repository.findAll().stream()
                .filter(h -> h instanceof Doble)
                .map(h -> mapper.getDtoDoble((Doble) h))
                .toList();
    }

    @Override
    public DobleResponseDto guardar(DobleRequestDto dto) {
        Doble doble= mapper.getEntityDoble(dto);
        Doble dobleGuardado=repository.save(doble);
        return mapper.getDtoDoble(dobleGuardado);
    }

    @Override
    public DobleResponseDto editar(Long id, DobleRequestDto dto) {
        repository.findById(id).orElseThrow();
        Doble doble = mapper.getEntityDoble(dto);
        doble.setId(id);
        Doble dobleActualizado = repository.save(doble);
        return mapper.getDtoDoble(dobleActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el id");
        }
        repository.deleteById(id);
    }

    @Override
    public DobleResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(h -> mapper.getDtoDoble((Doble) h))
                .orElseThrow(() -> new RuntimeException("No existe el Cocinero con ID: " + id));
    }
}
