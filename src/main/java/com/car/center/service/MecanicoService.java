package com.car.center.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.car.center.model.Mecanico;

public interface MecanicoService{

	public Iterable<Mecanico> findAll();
	public Page<Mecanico> findAll(Pageable pageable);
	public Optional<Mecanico> findById(Long id);
	public Mecanico save(Mecanico entity);
	public void deleteById(Long id);
	public Optional<Mecanico> findByEmail(String email);
	
}
