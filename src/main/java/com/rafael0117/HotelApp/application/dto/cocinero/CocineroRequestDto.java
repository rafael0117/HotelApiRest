package com.rafael0117.HotelApp.application.dto.cocinero;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CocineroRequestDto extends EmpleadoRequestDto {
    private String especialidad;
}
