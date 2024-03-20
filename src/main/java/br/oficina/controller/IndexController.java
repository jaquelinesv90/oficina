package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.Proprietario;
import br.oficina.repository.ProprietarioRepository;

@Controller
public class IndexController {
	
	@Autowired
	private ProprietarioRepository propRepository;
	
	@GetMapping("/login")
	public String showForm() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public ModelAndView submitForm() {
		List<Proprietario> todosProprietarios = propRepository.findAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaproprietarios", todosProprietarios);
		
		todosProprietarios.forEach(name ->{
			System.out.println("LISTA DE PROPRIETARIOS " + name.getNome());
		});
		
		return mv;
	}
	
}
