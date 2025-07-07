package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@Setter
public class Suite extends Habitacion{
    private boolean jacuzzi;
    private int cantidadAmbientes;
}
