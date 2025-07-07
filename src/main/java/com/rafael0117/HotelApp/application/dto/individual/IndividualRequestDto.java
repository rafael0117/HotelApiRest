package com.rafael0117.HotelApp.application.dto.individual;

import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class IndividualRequestDto extends HabitacionRequestDto {
    private boolean incluyeDesayuno;
}
