package com.rafael0117.HotelApp.application.mapper;

import com.rafael0117.HotelApp.application.dto.reserva.ReservaRequestDto;
import com.rafael0117.HotelApp.application.dto.reserva.ReservaResponseDto;
import com.rafael0117.HotelApp.domain.entity.Habitacion;
import com.rafael0117.HotelApp.domain.entity.Huesped;
import com.rafael0117.HotelApp.domain.entity.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {
    public Reserva getEntityReserva(ReservaRequestDto requestDto, Habitacion habitacion, Huesped huesped){
        return Reserva.builder()
                .fechaEntrada(requestDto.getFechaEntrada())
                .fechaSalida(requestDto.getFechaSalida())
                .estado(requestDto.getEstado())
                .habitacion(habitacion)
                .huesped(huesped)
                .build();
    }
    public ReservaResponseDto getDtoReserva(Reserva reserva){
        return ReservaResponseDto.builder()
                .id(reserva.getId())
                .fechaEntrada(reserva.getFechaEntrada())
                .fechaSalida(reserva.getFechaSalida())
                .estado(reserva.getEstado())
                .habitacion(reserva.getHabitacion().getTipo())
                .numero(reserva.getHabitacion().getNumero())
                .huesped(reserva.getHuesped().getNombreCompleto())
                .build();
    }

}
