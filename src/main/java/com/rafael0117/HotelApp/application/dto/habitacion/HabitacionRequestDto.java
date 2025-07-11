package com.rafael0117.HotelApp.application.dto.habitacion;

import com.rafael0117.HotelApp.domain.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionRequestDto {
    private String numero;
    private BigDecimal precio;
    private boolean disponible;
    private Tipo tipo;
}
