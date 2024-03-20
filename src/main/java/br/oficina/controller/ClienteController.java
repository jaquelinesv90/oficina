package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.Marca;
import br.oficina.repository.MarcaRepository;
import br.oficina.repository.ProprietarioRepository;

@Controller
@RequestMapping("/proprietario")
public class ClienteController {
	
	@Autowired
	private ProprietarioRepository propRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	

	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		List<Marca> todasMarcas = marcaRepository.findAll();
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("listaMarcas", todasMarcas);
		
		return mv;
	}
	
	
	@RequestMapping("/servico/novo")
	public String novoServico() {
		return "agendarServico.html";
	}
	
	@PostMapping("/servico/novo")
	public ModelAndView submitForm() {
		
		/*
		
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaproprietarios", todosProprietarios);
		
		
		
		todosProprietarios.forEach(name ->{
			System.out.println("LISTA DE PROPRIETARIOS " + name.getNome());
		});*/
		
		return null;
	} 
	
	
	@RequestMapping("/relatorio")
	public String relatorio() {
		return "relatorio.html";
	}
}
