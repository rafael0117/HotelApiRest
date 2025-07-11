package com.rafael0117.HotelApp.application.dto.administrador;

import com.rafael0117.HotelApp.domain.enums.Cargo;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@SuperBuilder
public class AdministradorResponseDto {
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private BigDecimal salario;
    private String usuario;
    private String password;
    private Cargo cargos;
    private LocalDate fechaIngreso;
    private String nivelAcceso;
}
