package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.Orcamento;
import br.oficina.repository.OrcamentoRepository;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@RequestMapping("/pesquisarOrcamento")
	public ModelAndView  listar() {
		List<Orcamento> todosOrcamentos = orcamentoRepository.findAll();
		
		ModelAndView mv = new ModelAndView("pesquisarOrcamentos");
		mv.addObject("listaOrcamentos", todosOrcamentos);
		
		return mv;
	}
	
	@RequestMapping("/novo")
	public String novo() {
		
		return "cadastrarOrcamento";
	}
}
