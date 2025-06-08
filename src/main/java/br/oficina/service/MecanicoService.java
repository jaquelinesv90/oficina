package br.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.Mecanico;
import br.oficina.repositories.MecanicoRepository;

@Service
public class MecanicoService {
	
	@Autowired
	private MecanicoRepository repository;
	
	public Mecanico findById(Long id) {
		return repository.findById(id).get();
	}

}
