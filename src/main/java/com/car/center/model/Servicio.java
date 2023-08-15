package com.car.center.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SERVICIOS")
public class Servicio implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 12381238123L;

	@Id
    @NotNull(message = "El código del servicio no puede estar en blanco")
    private Integer codigo;

    @NotBlank(message = "El nombre del servicio no puede estar en blanco")
    private String nombreServicio;

    @NotNull(message = "El precio del servicio no puede estar en blanco")
    @PositiveOrZero(message = "El precio del servicio debe ser positivo o cero")
    private BigDecimal precio;

	
}
