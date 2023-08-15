package com.car.center.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SERVICIOS_X_MANTENIMIENTOS")
public class ServicioMantenimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 121931239219391L;
	@Id
	private Integer codigo;
	private Integer tiempoEstimado;

	@ManyToOne
	@JoinColumn(name = "COD_SERVICIO")
	private Servicio servicio;

	@ManyToOne
	@JoinColumn(name = "COD_MANTENIMIENTO")
	private Mantenimiento mantenimiento;

}
