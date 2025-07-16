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
import java.util.Set;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "empleado_cargos",
            joinColumns = @JoinColumn(name = "empleado_id")
    )
    @Column(name = "cargo")
    @Enumerated(EnumType.STRING)
    private Set<Cargo> cargos;
    private LocalDate fechaIngreso;
}
