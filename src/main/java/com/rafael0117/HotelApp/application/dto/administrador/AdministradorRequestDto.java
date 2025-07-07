package com.rafael0117.HotelApp.application.dto.administrador;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AdministradorRequestDto extends EmpleadoRequestDto {
    private String nivelAcceso;
}
