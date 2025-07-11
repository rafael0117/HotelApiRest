package com.rafael0117.HotelApp.application.dto.habitacion;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Data
public class HabitacionResponseDto {
    private Long id;
    private String numero;
    private BigDecimal precio;
    private boolean disponible;
    //suite
    private boolean jacuzzi;
    private int cantidadAmbientes;
    //doble
    private boolean camaSeparadas;
    //individual
    private boolean incluyeDesayuno;
}
