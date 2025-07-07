package com.rafael0117.HotelApp.application.mapper;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.domain.entity.Doble;
import com.rafael0117.HotelApp.domain.entity.Individual;
import com.rafael0117.HotelApp.domain.entity.Suite;
import org.springframework.stereotype.Component;

@Component
public class HabitacionMapper {

    public Suite getEntitySuite(SuiteRequestDto requestDto){
        return Suite.builder()
                .numero(requestDto.getNumero())
                .precio(requestDto.getPrecio())
                .disponible(requestDto.isDisponible())
                .jacuzzi(requestDto.isJacuzzi())
                .cantidadAmbientes(requestDto.getCantidadAmbientes())
                .build();
    }
    public Individual getEntityIndividual(IndividualRequestDto requestDto){
        return Individual.builder()
                .numero(requestDto.getNumero())
                .precio(requestDto.getPrecio())
                .disponible(requestDto.isDisponible())
                .incluyeDesayuno(requestDto.isIncluyeDesayuno())
                .build();
    }
    public Doble getEntityDoble(DobleRequestDto requestDto){
        return Doble.builder()
                .numero(requestDto.getNumero())
                .precio(requestDto.getPrecio())
                .disponible(requestDto.isDisponible())
                .camaSeparadas(requestDto.isCamaSeparadas())
                .build();
    }
}
