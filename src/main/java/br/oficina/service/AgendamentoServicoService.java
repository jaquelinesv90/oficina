package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.model.AgendamentoServico;
import br.oficina.repository.AgendamentoServicoRepository;

@Service
public class AgendamentoServicoService {
	
	@Autowired
	AgendamentoServicoRepository repository;
	
	public List<AgendamentoServico> findAll(){
		return repository.findAll();
	}

}
