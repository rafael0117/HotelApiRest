package com.rafael0117.HotelApp.domain.entity;

import com.rafael0117.HotelApp.domain.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private BigDecimal salario;
    @Column(unique = true)
    private String usuario;
    private String password;

    @Enumerated(EnumType.STRING)
    private Cargo cargos;
    private LocalDate fechaIngreso;
}
