package com.rafael0117.HotelApp.domain.repository;

import com.rafael0117.HotelApp.domain.entity.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHuespedRepository extends JpaRepository<Huesped,Long> {
}
