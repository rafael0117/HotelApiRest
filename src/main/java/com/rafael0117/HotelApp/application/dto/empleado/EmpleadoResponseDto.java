package com.rafael0117.HotelApp.application.dto.empleado;

import com.rafael0117.HotelApp.domain.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoResponseDto {
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private BigDecimal salario;
    private String usuario;
    private String password;
    private Cargo cargos;
    private LocalDate fechaIngreso;
}
