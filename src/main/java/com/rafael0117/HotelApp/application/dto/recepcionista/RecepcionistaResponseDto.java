package com.rafael0117.HotelApp.application.dto.recepcionista;

import com.rafael0117.HotelApp.domain.enums.Cargo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class RecepcionistaResponseDto {
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private BigDecimal salario;
    private String usuario;
    private String password;
    private Set<Cargo> cargos;
    private LocalDate fechaIngreso;
    private String turno;
}
