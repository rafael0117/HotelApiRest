package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaRequestDto;
import com.rafael0117.HotelApp.application.dto.personalLimpieza.PersonalLimpiezaResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IPersonalLimpiezaService;
import com.rafael0117.HotelApp.domain.entity.PersonalLimpieza;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalLimpiezaServiceImpl implements IPersonalLimpiezaService {

    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    @Override
    public List<PersonalLimpiezaResponseDto> listar() {
        return repository.findAll().stream()
                .filter(e -> e instanceof PersonalLimpieza)
                .map(e -> mapper.getDtoPersonalLimpieza((PersonalLimpieza) e))
                .toList();
    }

    @Override
    public PersonalLimpiezaResponseDto guardarPersonalLimpieza(PersonalLimpiezaRequestDto dto) {
        PersonalLimpieza personal = mapper.getEntityPersonalLimpieza(dto);
        PersonalLimpieza guardado = repository.save(personal);
        return mapper.getDtoPersonalLimpieza(guardado);
    }

    @Override
    public PersonalLimpiezaResponseDto editarPersonalLimpieza(Long id, PersonalLimpiezaRequestDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el personal de limpieza con ID: " + id));
        PersonalLimpieza actualizado = mapper.getEntityPersonalLimpieza(dto);
        actualizado.setId(id);
        PersonalLimpieza guardado = repository.save(actualizado);
        return mapper.getDtoPersonalLimpieza(guardado);
    }

    @Override
    public PersonalLimpiezaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(e -> mapper.getDtoPersonalLimpieza((PersonalLimpieza) e))
                .orElseThrow(() -> new RuntimeException("No existe el personal de limpieza con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe el id: " + id);
        }
        repository.deleteById(id);
    }
}
