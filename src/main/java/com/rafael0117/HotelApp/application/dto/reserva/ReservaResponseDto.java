package com.rafael0117.HotelApp.application.dto.reserva;

import com.rafael0117.HotelApp.domain.enums.Tipo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservaResponseDto {
    private Long id;
    private String numero;
    private Tipo habitacion;
    private String huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;

}
