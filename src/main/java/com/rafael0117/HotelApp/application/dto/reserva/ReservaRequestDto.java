package com.rafael0117.HotelApp.application.dto.reserva;

import com.rafael0117.HotelApp.domain.entity.Habitacion;
import com.rafael0117.HotelApp.domain.entity.Huesped;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservaRequestDto {
    private Long habitacion;
    private Long huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;
}
