package com.rafael0117.HotelApp.domain.repository;

import com.rafael0117.HotelApp.domain.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva,Long> {
}
