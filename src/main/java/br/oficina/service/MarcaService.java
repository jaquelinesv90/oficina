package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.Marca;
import br.oficina.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;

	public List<Marca>  findAll(){
		return repository.findAll();
	}
}
