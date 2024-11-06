package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.model.Modelo;
import br.oficina.repository.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	
	public List<Modelo> pesquisaModeloPorMarca(String marca){
		return modeloRepository.findByMarca(marca);
	}

}
