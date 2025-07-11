package com.rafael0117.HotelApp.application.dto.empleado;

import com.rafael0117.HotelApp.domain.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
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
    //Administrador
    private String nivelAcceso;
    //Cocinero
    private String especialidad;
    //Mantenimiento
    private boolean disponible;
    private String areaResponsable;
    //Personal Limpieza
    private int pisosAsignados;
    //Recepcionista
    private String turno;
}
