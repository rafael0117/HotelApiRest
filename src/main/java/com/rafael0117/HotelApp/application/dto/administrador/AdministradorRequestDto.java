package com.rafael0117.HotelApp.application.dto.administrador;

import com.rafael0117.HotelApp.application.dto.empleado.EmpleadoRequestDto;
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
public class AdministradorRequestDto extends EmpleadoRequestDto {
    private String nivelAcceso;
}
