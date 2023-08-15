package com.car.center.service;

import java.util.List;

import com.car.center.model.Mecanico;

public interface AsignacionMecanicoService {

	public List<Mecanico> obtenerMecanicosDisponiblesEnOrdenDePrioridad();
	
}
