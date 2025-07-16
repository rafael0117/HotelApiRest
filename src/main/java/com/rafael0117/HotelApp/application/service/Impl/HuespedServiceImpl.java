package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.huesped.HuespedRequestDto;
import com.rafael0117.HotelApp.application.dto.huesped.HuespedResponseDto;
import com.rafael0117.HotelApp.application.mapper.HuespedMapper;
import com.rafael0117.HotelApp.application.service.IHuespedService;
import com.rafael0117.HotelApp.domain.entity.Huesped;
import com.rafael0117.HotelApp.domain.repository.IHuespedRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HuespedServiceImpl implements IHuespedService {
    private final IHuespedRepository repository;
    private final HuespedMapper mapper;
    @Override
    public List<HuespedResponseDto> listar() {
        return repository.findAll().stream().map(mapper::getDto).toList();
    }

    @Override
    public HuespedResponseDto guardar(HuespedRequestDto dto) {
        Huesped huesped = mapper.getEntity(dto);
        Huesped huespedGuardado = repository.save(huesped);
        return mapper.getDto(huespedGuardado);
    }

    @Override
    public HuespedResponseDto editar(Long id, HuespedRequestDto dto) {
        repository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el ID"));
        Huesped huesped = mapper.getEntity(dto);
        huesped.setId(id);
        Huesped huespedActualizado =repository.save(huesped);
        return mapper.getDto(huespedActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No se encontro el ID");
        }
        repository.deleteById(id);
    }

    @Override
    public HuespedResponseDto buscarPorId(Long id) {
        return repository.findById(id).map(mapper::getDto).orElseThrow(()-> new RuntimeException("No se encontro el ID"));
    }
}
