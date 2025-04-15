package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.FormaPagamento;
import br.oficina.repositories.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	
	@Autowired
	private FormaPagamentoRepository repository;
	
	public List<FormaPagamento> findAll(){
		return repository.findAll();
	}

}
