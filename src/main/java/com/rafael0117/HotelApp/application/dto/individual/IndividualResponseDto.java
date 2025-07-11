package com.rafael0117.HotelApp.application.dto.individual;

import com.rafael0117.HotelApp.domain.enums.Tipo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class IndividualResponseDto {
    private Long id;
    private String numero;
    private BigDecimal precio;
    private boolean disponible;
    private Tipo tipo;
    private boolean incluyeDesayuno;
}
