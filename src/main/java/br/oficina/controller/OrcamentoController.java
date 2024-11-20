package br.oficina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.oficina.repository.OrcamentoRepository;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@RequestMapping("/pesquisarOrcamento")
	public String  listar() {
				
		return "pesquisarOrcamentos";
	}
	
	@RequestMapping("/novo")
	public String novo() {
		
		return "cadastrarOrcamento";
	}
}
