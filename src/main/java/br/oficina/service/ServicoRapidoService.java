package br.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.ServicoRapido;
import br.oficina.repositories.ServicoRapidoRepository;
import br.oficina.util.GenericUtils;

@Service
public class ServicoRapidoService {
	
	@Autowired
	private ServicoRapidoRepository repository;
	
	public void salvar(ServicoRapido servico) {
		servico.setPreco(GenericUtils.removeFormatacaoMonetaria(servico.getPreco().toString()));
		
		repository.save(servico);
	}
	
}
