package br.oficina.service;

import org.springframework.stereotype.Service;

import br.oficina.model.Orcamento;
import br.oficina.repository.OrcamentoRepository;

@Service
public class OrcamentoService {
	
	private OrcamentoRepository repository;
	
	public void salvar(Orcamento orcamento) {
		repository.save(orcamento);
	}

}
