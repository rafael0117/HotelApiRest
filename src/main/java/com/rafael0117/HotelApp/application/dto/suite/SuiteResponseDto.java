package com.rafael0117.HotelApp.application.dto.suite;

import com.rafael0117.HotelApp.domain.enums.Tipo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class SuiteResponseDto {
    private Long id;
    private String numero;
    private BigDecimal precio;
    private boolean disponible;
    private Tipo tipo;
    private boolean jacuzzi;
    private int cantidadAmbientes;
}
