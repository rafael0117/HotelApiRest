package com.rafael0117.HotelApp.application.dto.reserva;

import java.time.LocalDate;

public class ReservaResponseDto {
    private Long id;
    private Long habitacion;
    private Long huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;
}
