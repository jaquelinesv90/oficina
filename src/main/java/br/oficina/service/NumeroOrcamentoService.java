package br.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.NumeroOrcamento;
import br.oficina.repositories.NumeroOrcamentoRepository;

@Service
public class NumeroOrcamentoService {
	
	@Autowired
	private NumeroOrcamentoRepository repository;
	
	public NumeroOrcamento findById(Long numOrcamento) {
		return repository.findById(numOrcamento).get();
	}
	
	public void salvar(NumeroOrcamento numeroOrcamento) {
		repository.save(numeroOrcamento);
	}

}
