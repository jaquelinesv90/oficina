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
	
	@RequestMapping
	public ModelAndView listar() {
		
		List<Orcamento> listaOrcamentos = orcamentoRepository.findAll();
		ModelAndView mv = new ModelAndView("listarOrcamentos");
		mv.addObject("listaOrcamentos",listaOrcamentos);
		
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	

}
