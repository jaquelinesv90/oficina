package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.Cliente;
import br.oficina.model.Marca;
import br.oficina.model.Modelo;
import br.oficina.repository.ClienteRepository;
import br.oficina.repository.MarcaRepository;
import br.oficina.repository.ModeloRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
		
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		List<Modelo> todosModelos = modeloRepository.findAll();
		List<Marca> todasMarcas = marcaRepository.findAll();
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelo",todosModelos);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Cliente cliente) {
		clienteRepository.save(cliente);
		
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		return mv;
	}

}
