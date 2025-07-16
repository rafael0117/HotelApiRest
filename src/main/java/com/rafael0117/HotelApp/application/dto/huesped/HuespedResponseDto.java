package com.rafael0117.HotelApp.application.dto.huesped;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HuespedResponseDto {
    private Long id;
    private String nombreCompleto;
    private String dni;
    private String correo;
}
