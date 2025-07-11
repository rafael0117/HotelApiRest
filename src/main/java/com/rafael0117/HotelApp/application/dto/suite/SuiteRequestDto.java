package com.rafael0117.HotelApp.application.dto.suite;

import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SuiteRequestDto extends HabitacionRequestDto {
    private boolean jacuzzi;
    private int cantidadAmbientes;
}
