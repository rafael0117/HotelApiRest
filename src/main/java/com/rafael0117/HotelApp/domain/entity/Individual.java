package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Individual extends Habitacion{
    private boolean incluyeDesayuno;
}
