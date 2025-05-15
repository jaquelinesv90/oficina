package br.oficina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.models.Carro;
import br.oficina.models.Cliente;
import br.oficina.models.Marca;
import br.oficina.models.Modelo;
import br.oficina.repositories.ClienteRepository;
import br.oficina.service.ClienteService;
import br.oficina.service.MarcaService;
import br.oficina.service.ModeloService;
import br.oficina.service.PaginacaoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private PaginacaoService paginacaoService;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = inicializarCamposAutoPreenchidos();
		mv.addObject(new Cliente());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Cliente cliente) {
		clienteService.salvar(cliente);
		
		ModelAndView mv = inicializarCamposAutoPreenchidos();
		
		mv.addObject("mensagem","Cliente salvo com sucesso");
		return mv;
	}
	

	public ModelAndView inicializarCamposAutoPreenchidos() {
		
		List<Marca> todasMarcas = marcaService.findAll();
		
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelos", new Modelo());
		mv.addObject("listaCarros", new Carro());
		
		mv.addObject(new Cliente());
		
		return mv;
	}
	
	//via javascript
	@RequestMapping(value = "/{idSelecionado}/pesquisaModelo", method = RequestMethod.GET)
	public ResponseEntity<List<Modelo>> preencherCampoModelo(@PathVariable Long idSelecionado) {
		
		List<Modelo> listaModelos = modeloService.findAllModelosByIdMarca(idSelecionado);
		
		return new ResponseEntity<List<Modelo>>(listaModelos, HttpStatus.OK);
	}
	
	//pag de pesquisar cliente
	@RequestMapping(value = "/pesquisarCliente",method=RequestMethod.GET) 
	public String pesquisarCliente(@ModelAttribute("filtro") PesquisaClienteFilter nome, Model model) {
		
		return findPaginated("nome","asc",1,nome,model);
	}
	
	@GetMapping("/pesquisarCliente/pagina/{pageNum}")
	public String findPaginated( 
		@RequestParam("sortField") String sortField,
		@RequestParam("sortDir") String sortDir,
		@PathVariable (value = "pageNum") int pageNum,
		@ModelAttribute("filtro") PesquisaClienteFilter nome,
		Model model) {
					
		model = paginacaoService.findPaginated(
				sortField, sortDir, pageNum, model, clienteRepository);
				
		model.addAttribute("listaClientes", model.getAttribute("lista"));
		model.addAttribute("url","/cliente/pesquisarCliente/pagina/");
				
		return "pesquisarCliente";
	}
	
	@RequestMapping("{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = clienteService.findById(id);
		
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv = inicializarCamposAutoPreenchidos();
		
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE) 
	public String excluir(@PathVariable Long id) {
		
		clienteService.excluir(id);
		
		return "redirect:/pesquisarCliente";
	}
}