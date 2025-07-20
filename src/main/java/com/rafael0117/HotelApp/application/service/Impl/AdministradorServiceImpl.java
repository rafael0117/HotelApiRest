package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.administrador.AdministradorRequestDto;
import com.rafael0117.HotelApp.application.dto.administrador.AdministradorResponseDto;
import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoResponseDto;
import com.rafael0117.HotelApp.application.mapper.EmpleadoMapper;
import com.rafael0117.HotelApp.application.service.IAdministradorService;
import com.rafael0117.HotelApp.domain.entity.Administrador;
import com.rafael0117.HotelApp.domain.repository.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements IAdministradorService {
    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    @Override
    public List<AdministradorResponseDto> listar() {
        return repository.findAll().stream()
                .filter(e -> e instanceof Administrador) // ← Filtra solo los administradores
                .map(e -> mapper.getDtoAdministrador((Administrador) e))
                .toList();
    }


    @Override
    public AdministradorResponseDto guardarAdministrador(AdministradorRequestDto dto) {
        Administrador admin = mapper.getEntityAdministrador(dto);
        Administrador guardado = repository.save(admin);
        return mapper.getDtoAdministrador(guardado);
    }

    @Override
    public AdministradorResponseDto editarAdministrador(Long id, AdministradorRequestDto dto) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el administrador con ID: " + id));
        Administrador admin = mapper.getEntityAdministrador(dto);
        admin.setId(id);
        Administrador actualizado = repository.save(admin);
        return mapper.getDtoAdministrador(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el id:"+id);
        }
        repository.deleteById(id);
    }



    @Override
    public AdministradorResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(e -> mapper.getDtoAdministrador((Administrador) e))
                .orElseThrow(() -> new RuntimeException("No existe el Administrador con ID: " + id));
    }

}
