package com.rafael0117.HotelApp.domain.entity;


import com.rafael0117.HotelApp.domain.enums.Cargo;
import com.rafael0117.HotelApp.domain.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private BigDecimal precio;
    private boolean disponible;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

}
