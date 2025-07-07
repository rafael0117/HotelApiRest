package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
public class Individual extends Habitacion{
    private boolean incluyeDesayuno;
}
