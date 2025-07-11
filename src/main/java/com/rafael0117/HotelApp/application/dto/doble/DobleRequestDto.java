package com.rafael0117.HotelApp.application.dto.doble;

import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionRequestDto;
import com.rafael0117.HotelApp.domain.entity.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class DobleRequestDto extends HabitacionRequestDto {
    private boolean camaSeparadas;
}
