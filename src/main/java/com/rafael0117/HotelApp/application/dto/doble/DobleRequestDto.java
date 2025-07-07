package com.rafael0117.HotelApp.application.dto.doble;

import com.rafael0117.HotelApp.domain.entity.Habitacion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class DobleRequestDto extends Habitacion {
    private boolean camaSeparadas;
}
