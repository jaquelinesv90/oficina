package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.AgendamentoServico;
import br.oficina.service.AgendamentoServicoService;
import br.oficina.service.IndexService;
import br.oficina.utils.DateUtils;

@Controller
public class IndexController {
	
	@Autowired
	private AgendamentoServicoService agendamentoService;
	
	@Autowired
	private IndexService indexService;
	
	
	@GetMapping("/login")
	public String showForm() {
		return "login.html";
	}
	
	@GetMapping("/index")
	public ModelAndView listarAgendamentos() {
		
		String dataAtual = DateUtils.getDataAtual();
		List<AgendamentoServico> listaAgendamento = agendamentoService.findAll();
				
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaclientes", listaAgendamento);
		mv.addObject("dataAtual", dataAtual);
		
		return mv;
	}
	
	//redirecionar para tela de pesquisa
	@GetMapping("/pesquisar")
	public String pesquisar() {
		return "pesquisar.html";
	}
	
	@GetMapping("/esqueciSenha")
	public String esqueciSenha() {
		return "esqueciSenha.html";
	}
	
	@GetMapping("/novaSenha")
	public void novaSenha() {
		indexService.enviarEmail();

	}
	
	
	/*
	@GetMapping("/")
	public ModelAndView listar() {
		
		List<AgendamentoServico> listaAgendamento = agendRepository.findAll();
				
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaclientes", listaAgendamento);
		
		listaAgendamento.forEach(name ->{
			System.out.println("LISTA DE PROPRIETARIOS " + name.getCliente().getNome());
		});
		
		return mv;
	}*/
}
