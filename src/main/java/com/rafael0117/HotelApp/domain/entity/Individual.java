package com.rafael0117.HotelApp.domain.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Individual extends Habitacion{
    private boolean incluyeDesayuno;
}
