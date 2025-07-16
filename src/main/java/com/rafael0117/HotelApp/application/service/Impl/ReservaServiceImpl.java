package com.rafael0117.HotelApp.application.service.Impl;

import com.rafael0117.HotelApp.application.dto.reserva.ReservaRequestDto;
import com.rafael0117.HotelApp.application.dto.reserva.ReservaResponseDto;
import com.rafael0117.HotelApp.application.mapper.ReservaMapper;
import com.rafael0117.HotelApp.application.service.IReservaService;
import com.rafael0117.HotelApp.domain.entity.Habitacion;
import com.rafael0117.HotelApp.domain.entity.Huesped;
import com.rafael0117.HotelApp.domain.entity.Reserva;
import com.rafael0117.HotelApp.domain.repository.IHabitacionRepository;
import com.rafael0117.HotelApp.domain.repository.IHuespedRepository;
import com.rafael0117.HotelApp.domain.repository.IReservaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements IReservaService {
    private final IReservaRepository repository;
    private final ReservaMapper mapper;
    private final IHabitacionRepository habitacionRepository;
    private final IHuespedRepository huespedRepository;

    @Override
    public List<ReservaResponseDto> listar() {
        return repository.findAll().stream().map(mapper::getDtoReserva).toList();
    }

    @Override
    @Transactional
    public ReservaResponseDto guardar(ReservaRequestDto dto) {
        Habitacion habitacion = habitacionRepository.findById(dto.getHabitacion())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        Huesped huesped = huespedRepository.findById(dto.getHuesped())
                .orElseThrow(() -> new RuntimeException("Huésped no encontrado"));

        Reserva reserva = mapper.getEntityReserva(dto, habitacion, huesped);
        Reserva reservaGuardada = repository.save(reserva);

        return mapper.getDtoReserva(reservaGuardada);
    }


    @Override
    @Transactional
    public ReservaResponseDto editar(Long id, ReservaRequestDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la reserva con ID: " + id));

        Habitacion habitacion = habitacionRepository.findById(dto.getHabitacion())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        Huesped huesped = huespedRepository.findById(dto.getHuesped())
                .orElseThrow(() -> new RuntimeException("Huésped no encontrado"));

        Reserva reserva = mapper.getEntityReserva(dto, habitacion, huesped);
        reserva.setId(id); // Muy importante para editar

        Reserva actualizada = repository.save(reserva);
        return mapper.getDtoReserva(actualizada);
    }


    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No se encontro el ID");
        }
        repository.deleteById(id);
    }

    @Override
    public ReservaResponseDto buscarPorId(Long id) {
        return repository.findById(id).map(mapper::getDtoReserva).orElseThrow(()-> new RuntimeException("No se encontro el ID"));
    }
}
