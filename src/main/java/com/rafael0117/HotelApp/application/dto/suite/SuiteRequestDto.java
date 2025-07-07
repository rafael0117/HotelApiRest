package com.rafael0117.HotelApp.application.dto.suite;

import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class SuiteRequestDto extends HabitacionRequestDto {
    private boolean jacuzzi;
    private int cantidadAmbientes;
}
