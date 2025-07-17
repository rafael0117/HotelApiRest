package com.rafael0117.HotelApp.domain.entity;

import com.rafael0117.HotelApp.domain.enums.NivelAcceso;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Empleado{
    @Enumerated(EnumType.STRING)
    private NivelAcceso nivelAcceso;

}
