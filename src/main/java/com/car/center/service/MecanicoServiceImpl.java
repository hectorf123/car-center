package com.car.center.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.center.model.Mecanico;
import com.car.center.repository.MecanicoRepository;


@Service
public class MecanicoServiceImpl implements MecanicoService{

    @Autowired
    private MecanicoRepository repository;
	
    @Override
	@Transactional(readOnly = true)
	public Iterable<Mecanico> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Mecanico> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mecanico> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Mecanico save(Mecanico entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
    
	@Override
	@Transactional(readOnly = true)
	public Optional<Mecanico> findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
