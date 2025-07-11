package com.rafael0117.HotelApp.application.dto.recepcionista;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecepcionistaRequestDto extends EmpleadoRequestDto {
    private String turno;
}
