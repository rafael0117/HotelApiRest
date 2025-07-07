package com.rafael0117.HotelApp.application.dto.mantenimiento;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class MantenimientoRequestDto extends EmpleadoRequestDto {
    private boolean disponible;
    private String areaResponsable;
}
