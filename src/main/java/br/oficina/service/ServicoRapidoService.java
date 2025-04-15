package br.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.ServicoRapido;
import br.oficina.repositories.ServicoRapidoRepository;

@Service
public class ServicoRapidoService {
	
	@Autowired
	private ServicoRapidoRepository repository;
	
	public void salvar(ServicoRapido servico) {
		repository.save(servico);
	}
}
