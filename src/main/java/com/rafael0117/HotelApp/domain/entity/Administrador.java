package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity

@Getter
@Setter
@SuperBuilder
public class Administrador extends Empleado{
    private String nivelAcceso;
}
