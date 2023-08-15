package com.car.center.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "MECANICOS")
public class Mecanico implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1987654323456789L;

	@Id
    @NotNull(message = "El documento no puede estar en blanco")
    private Long documento;
    
    @NotBlank(message = "El tipo de documento no puede estar en blanco")
    @Size(max = 2, message = "El tipo de documento debe tener máximo {max} caracteres")
    private String tipoDocumento;


    @NotBlank(message = "El primer nombre no puede estar en blanco")
    @Size(max = 30, message = "El primer nombre debe tener máximo {max} caracteres")
    private String primerNombre;

    @Size(max = 30, message = "El segundo nombre debe tener máximo {max} caracteres")
    private String segundoNombre;

    @NotBlank(message = "El primer apellido no puede estar en blanco")
    @Size(max = 30, message = "El primer apellido debe tener máximo {max} caracteres")
    private String primerApellido;

    @Size(max = 30, message = "El segundo apellido debe tener máximo {max} caracteres")
    private String segundoApellido;

    @NotBlank(message = "El número de celular no puede estar en blanco")
    @Pattern(regexp = "[0-9]{10}", message = "El número de celular debe tener 10 dígitos")
    private String celular;

    @NotBlank(message = "La dirección no puede estar en blanco")
    @Size(max = 200, message = "La dirección debe tener máximo {max} caracteres")
    private String direccion;

    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Size(max = 100, message = "El correo electrónico debe tener máximo {max} caracteres")
    @Email(message = "no es válido")
    private String email;

    @NotBlank(message = "El estado no puede estar en blanco")
    @Pattern(regexp = "[A-Z]", message = "El estado debe ser un carácter en mayúscula")
    private String estado;

}