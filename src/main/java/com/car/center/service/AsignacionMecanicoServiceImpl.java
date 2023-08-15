package com.car.center.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.center.model.Mantenimiento;
import com.car.center.model.Mecanico;
import com.car.center.model.ServicioMantenimiento;
import com.car.center.payload.Estado;
import com.car.center.repository.MantenimientoRepository;
import com.car.center.repository.MecanicoRepository;
import com.car.center.repository.ServiciosMantenimientosRepository;

@Service
public class AsignacionMecanicoServiceImpl implements AsignacionMecanicoService {

	@Autowired
	private MecanicoRepository mecanicoRepository;

	@Autowired
	private MantenimientoRepository mantenimientoRepository;

	@Autowired
	private ServiciosMantenimientosRepository servicioMantenimientoRepository;

	@Override
	public List<Mecanico> obtenerMecanicosDisponiblesEnOrdenDePrioridad() {
		List<Mecanico> mecanicos = mecanicoRepository.findAll();

		// Filtrar los mecánicos disponibles en este instante
		mecanicos = mecanicos.stream().filter(mecanico -> estaLibreEnEsteInstante(mecanico))
				.collect(Collectors.toList());

		// Ordenar los mecánicos por prioridad (menos asignaciones en el último mes
		// tiene mayor prioridad)
		mecanicos.sort(Comparator.comparingInt(this::calcularPrioridadMecanico));

		// Limitar la lista a los primeros 10 mecánicos
		return mecanicos.stream().limit(10).collect(Collectors.toList());
	}

	private boolean estaLibreEnEsteInstante(Mecanico mecanico) {
		System.out.println(mecanico.getDocumento());

		List<ServicioMantenimiento> asignacionesActuales = servicioMantenimientoRepository
				.buscarServiciosPorDocumentoFechaEstado(mecanico.getDocumento(), LocalDate.now(),
						Estado.MANTENIMIENTO_EN_PROGRESO);
		System.out.println("Fecha" + LocalDate.now());

		System.out.println("size" + asignacionesActuales.size());

		int tiempoTotalAsignado = asignacionesActuales.stream().mapToInt(ServicioMantenimiento::getTiempoEstimado)
				.sum();

		System.out.println(tiempoTotalAsignado);

		int tiempoEstimadoProximoMantenimiento = 120;// Obtener el tiempo estimado del próximo mantenimiento

		/*
		 * List<Mantenimiento> asignacionesActuales =
		 * mantenimientoRepository.findByMecanicoAndFechaAndEstado(mecanico,
		 * LocalDate.now(), Estado.MANTENIMIENTO_EN_PROGRESO); LocalTime horaActual =
		 * LocalTime.now();
		 * 
		 * for (Mantenimiento asignacion : asignacionesActuales) { if
		 * (horaActual.isAfter(asignacion.getHoraInicio()) &&
		 * horaActual.isBefore(asignacion.getHoraFin())) { return false; // El mecánico
		 * está ocupado en este instante } }
		 */

		int TIEMPO_MAXIMO = 180;
	

		return tiempoTotalAsignado + tiempoEstimadoProximoMantenimiento <= TIEMPO_MAXIMO; // Placeholder, ajustar según
																							// lógica real
	}

	private int calcularPrioridadMecanico(Mecanico mecanico) {
		// Implementar lógica para calcular la prioridad basada en las asignaciones del
		// último mes
		// Puedes utilizar la información de Mantenimiento y ServiciosMantenimientos
		return 0; // Placeholder, ajustar según lógica real
	}

}
