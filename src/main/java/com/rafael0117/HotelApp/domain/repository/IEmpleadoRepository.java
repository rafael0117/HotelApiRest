package com.rafael0117.HotelApp.domain.repository;

import com.rafael0117.HotelApp.domain.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
    Optional<Empleado> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}
