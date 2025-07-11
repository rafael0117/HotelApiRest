package com.rafael0117.HotelApp.application.mapper;

import com.rafael0117.HotelApp.application.dto.doble.DobleRequestDto;
import com.rafael0117.HotelApp.application.dto.doble.DobleResponseDto;
import com.rafael0117.HotelApp.application.dto.habitacion.HabitacionResponseDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualRequestDto;
import com.rafael0117.HotelApp.application.dto.individual.IndividualResponseDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteRequestDto;
import com.rafael0117.HotelApp.application.dto.suite.SuiteResponseDto;
import com.rafael0117.HotelApp.domain.entity.Doble;
import com.rafael0117.HotelApp.domain.entity.Habitacion;
import com.rafael0117.HotelApp.domain.entity.Individual;
import com.rafael0117.HotelApp.domain.entity.Suite;
import org.springframework.stereotype.Component;

@Component
public class HabitacionMapper {

    public HabitacionResponseDto getDtoHabitacion(Habitacion habitacion){
        return HabitacionResponseDto.builder()
                .id(habitacion.getId())
                .numero(habitacion.getNumero())
                .precio(habitacion.getPrecio())
                .disponible(habitacion.isDisponible())
                .build();
    }
    public SuiteResponseDto getDtoSuite(Suite suite){
        return SuiteResponseDto.builder()
                .numero(suite.getNumero())
                .precio(suite.getPrecio())
                .disponible(suite.isDisponible())
                .tipo(suite.getTipo())
                .jacuzzi(suite.isJacuzzi())
                .cantidadAmbientes(suite.getCantidadAmbientes())
                .build();
    }
    public DobleResponseDto getDtoDoble(Doble doble){
        return DobleResponseDto.builder()
                .numero(doble.getNumero())
                .precio(doble.getPrecio())
                .disponible(doble.isDisponible())
                .tipo(doble.getTipo())
                .camaSeparadas(doble.isCamaSeparadas())
                .build();
    }
    public IndividualResponseDto getDtoIndividual(Individual individual){
        return IndividualResponseDto.builder()
                .numero(individual.getNumero())
                .precio(individual.getPrecio())
                .disponible(individual.isDisponible())
                .tipo(individual.getTipo())
                .incluyeDesayuno(individual.isIncluyeDesayuno())
                .build();
    }

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
