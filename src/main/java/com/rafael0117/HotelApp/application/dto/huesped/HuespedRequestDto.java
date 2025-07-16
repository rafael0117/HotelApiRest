package com.rafael0117.HotelApp.application.dto.huesped;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HuespedRequestDto {
    private String nombreCompleto;
    private String dni;
    private String correo;
}
