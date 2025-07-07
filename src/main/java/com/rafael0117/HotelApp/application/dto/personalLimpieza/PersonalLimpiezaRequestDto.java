package com.rafael0117.HotelApp.application.dto.personalLimpieza;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PersonalLimpiezaRequestDto extends EmpleadoRequestDto {
    private int pisosAsignados;
}
