package com.rafael0117.HotelApp.application.dto.individual;

import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class IndividualRequestDto extends HabitacionRequestDto {
    private boolean incluyeDesayuno;
}
