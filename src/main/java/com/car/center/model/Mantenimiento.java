package com.car.center.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "MANTENIMIENTOS")
public class Mantenimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 131842193912L;
	@Id
    private Integer codigo;
    private Integer estado;
    private String codPlaca;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "MEC_DOCUMENTO", referencedColumnName = "DOCUMENTO")
    private Mecanico mecanico;

	
}
