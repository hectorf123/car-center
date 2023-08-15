package com.car.center.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.center.model.Mecanico;
import com.car.center.payload.ResponseCodes;
import com.car.center.service.AsignacionMecanicoService;
import com.car.center.service.MecanicoService;

@RestController
public class MecanicoController{

	@Autowired
	MecanicoService service;
	
	@Autowired
    AsignacionMecanicoService asignacionMecanicoService;
	
	@GetMapping()
	public ResponseEntity<?> listarMecanicos() {
		System.out.println("Entra");
		Iterable<Mecanico> meca = new ArrayList<>();
		meca = service.findAll();
		for (Mecanico mecanico : meca) {
			System.out.println(mecanico.getPrimerNombre());
		}
		return ResponseEntity.ok().body(service.findAll());
	
	}


	@PutMapping("/modificar-mecanico/{id}")
	public ResponseEntity<?> modificarMecanico(@RequestBody Mecanico mecanico, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Mecanico> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Mecanico meca = optional.get();
		meca.setTipoDocumento(mecanico.getTipoDocumento());
		meca.setDocumento(mecanico.getDocumento());
		meca.setPrimerNombre(mecanico.getPrimerNombre());
		meca.setSegundoNombre(mecanico.getSegundoNombre());
		meca.setPrimerApellido(mecanico.getPrimerApellido());
		meca.setSegundoApellido(mecanico.getSegundoApellido());
		meca.setCelular(mecanico.getCelular());
		meca.setDireccion(mecanico.getDireccion());
		meca.setEmail(mecanico.getEmail());
		meca.setEstado(mecanico.getEstado());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(meca));
	}

	@PostMapping("/crear-mecanico")
	public ResponseEntity<?> crearMecanico(@Valid @RequestBody Mecanico mecanico, BindingResult result) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Mecanico> meca = service.findByEmail(mecanico.getEmail());
		if (meca.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCodes("403", "El Mecánico ya existe en el sistema"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(mecanico));
	}
	
	
	@GetMapping("/mecanicos-disponibles")
    public List<Mecanico> obtenerMecanicosDisponibles() {
        return asignacionMecanicoService.obtenerMecanicosDisponiblesEnOrdenDePrioridad();
    }

	// - Validación
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
