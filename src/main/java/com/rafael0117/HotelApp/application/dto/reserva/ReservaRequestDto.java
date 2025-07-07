package com.rafael0117.HotelApp.application.dto.reserva;

import com.rafael0117.HotelApp.domain.entity.Habitacion;
import com.rafael0117.HotelApp.domain.entity.Huesped;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservaRequestDto {
    private Long habitacion;
    private Long huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;
}
