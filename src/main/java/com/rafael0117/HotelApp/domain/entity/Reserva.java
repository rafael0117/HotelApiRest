package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Habitacion habitacion;
    @ManyToOne
    private Huesped huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;
}
