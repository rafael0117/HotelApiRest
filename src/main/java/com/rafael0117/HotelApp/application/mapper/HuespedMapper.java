package com.rafael0117.HotelApp.application.mapper;

import com.rafael0117.HotelApp.application.dto.huesped.HuespedRequestDto;
import com.rafael0117.HotelApp.application.dto.huesped.HuespedResponseDto;
import com.rafael0117.HotelApp.domain.entity.Huesped;
import org.springframework.stereotype.Component;

@Component
public class HuespedMapper {
    public HuespedResponseDto getDto(Huesped huesped){
        return HuespedResponseDto.builder()
                .id(huesped.getId())
                .dni(huesped.getDni())
                .correo(huesped.getCorreo())
                .nombreCompleto(huesped.getNombreCompleto())
                .build();
    }
    public Huesped getEntity(HuespedRequestDto dto){
        return Huesped.builder()
                .dni(dto.getDni())
                .correo(dto.getCorreo())
                .nombreCompleto(dto.getNombreCompleto())
                .build();
    }
}
