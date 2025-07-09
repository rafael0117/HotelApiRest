package com.rafael0117.HotelApp.domain.repository;

import com.rafael0117.HotelApp.domain.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHabitacionRepository extends JpaRepository<Habitacion,Long> {
}
