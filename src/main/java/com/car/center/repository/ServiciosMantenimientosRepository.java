package com.car.center.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.car.center.model.ServicioMantenimiento;

@Repository
public interface ServiciosMantenimientosRepository extends JpaRepository<ServicioMantenimiento, Integer> {

	@Query(value = "SELECT * FROM Servicios_x_Mantenimientos sm " +
	           "JOIN Mantenimientos m ON sm.cod_mantenimiento = m.codigo " +
	           "JOIN Mecanicos meca ON m.mec_documento = meca.documento " +
	           "WHERE meca.documento = :documento " +
	           "AND m.fecha >= TO_DATE(:fecha, 'dd/MM/yyyy') " +
	           "AND m.estado = :estado", nativeQuery = true)
     List<ServicioMantenimiento> buscarServiciosPorDocumentoFechaEstado(
         @Param("documento") Long documento,
         @Param("fecha") LocalDate fecha,
         @Param("estado") Integer estado);
}