package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.Modelo;
import br.oficina.repositories.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	public List<Modelo> findAll(){
		return modeloRepository.findAll();
	}
	
	public List<Modelo> findAllModelosByIdMarca(Long id){
		return modeloRepository.findAllModelosByIdMarca(id);
	}
}
