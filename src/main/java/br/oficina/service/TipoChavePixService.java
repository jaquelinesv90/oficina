package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.TipoChavePix;
import br.oficina.repositories.TipoChavePixRepository;

@Service
public class TipoChavePixService {
	
	@Autowired
	private TipoChavePixRepository repository;

	public List<TipoChavePix>  findAll(){
		return repository.findAll();
	}
	
}
