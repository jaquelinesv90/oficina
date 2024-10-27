package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.model.Carro;
import br.oficina.model.Cliente;
import br.oficina.model.Marca;
import br.oficina.model.Modelo;
import br.oficina.repository.ClienteRepository;
import br.oficina.repository.MarcaRepository;
import br.oficina.repository.ModeloRepository;
import br.oficina.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = inicializarCamposAutoPreenchidos();
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Cliente cliente) {
		clienteService.salvar(cliente);
		
		ModelAndView mv = inicializarCamposAutoPreenchidos();
		
		mv.addObject("mensagem","Cliente salvo com sucesso");
		return mv;
	}
	
	public ModelAndView inicializarCamposAutoPreenchidos() {
		
		List<Modelo> todosModelos = modeloRepository.findAll();
		List<Marca> todasMarcas = marcaRepository.findAll();
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelo",todosModelos);
		mv.addObject("listaCarros", new Carro());
		mv.addObject(new Cliente());
		
		return mv;
	}
	
	//mudar nome do metodo
	@RequestMapping(value = "/pesquisarCliente", method=RequestMethod.GET) 
	public ModelAndView abrirPaginaPesquisaCliente(@ModelAttribute("filtro") PesquisaClienteFilter nome) {
		List<Cliente> todosClientes = clienteService.filtrar(nome);
		ModelAndView mv = new ModelAndView("pesquisarCliente");
		mv.addObject("listaClientes",todosClientes);
		
		return mv;
	}
	
	/*
	public List<Cliente> buscarTodosClientes(){
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}*/
	
	
	@RequestMapping("{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.getById(id);
		
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE) 
	public String excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		
		return "redirect:/pesquisarCliente";
	}
}
