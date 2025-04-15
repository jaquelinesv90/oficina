package br.oficina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.models.ServicoRapido;
import br.oficina.service.ServicoRapidoService;

@Controller
@RequestMapping("/servicoRapido")
public class ServicoRapidoController {
	
	@Autowired
	private ServicoRapidoService service;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastrarServicoRapido");
		mv.addObject(new ServicoRapido());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(ServicoRapido servico) {
		service.salvar(servico);
		
		ModelAndView mv = new ModelAndView("cadastrarServicoRapido");
		
		mv.addObject("mensagem","Serviço Rápido salvo com sucesso");
		return mv;
	}
}
