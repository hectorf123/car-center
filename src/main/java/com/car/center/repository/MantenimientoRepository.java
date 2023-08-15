package com.car.center.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.center.model.Mantenimiento;
import com.car.center.model.Mecanico;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {

    public List<Mantenimiento> findByMecanicoAndFechaAndEstado(Mecanico mecanico, LocalDate fecha, Integer estado);

	
}
