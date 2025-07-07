package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
public class Cocinero extends Empleado{
    private String especialidad;
}

