package com.car.center.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.center.model.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long>{

	public Optional<Mecanico> findByEmail(String email);
	
}
