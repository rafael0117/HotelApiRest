package com.rafael0117.HotelApp.application.dto.habitacion;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
public class HabitacionRequestDto {
    private String numero;
    private BigDecimal precio;
    private boolean disponible;

}
