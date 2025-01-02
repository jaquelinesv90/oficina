package br.oficina.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.model.Carro;
import br.oficina.model.Cliente;
import br.oficina.model.Marca;
import br.oficina.model.Modelo;
import br.oficina.service.ClienteService;
import br.oficina.service.MarcaService;
import br.oficina.service.ModeloService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
		
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private ModeloService modeloService;
	

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
		
		List<Marca> todasMarcas = marcaService.findAll();
		//List<Modelo> todosModelos = modeloService.findAll();
		
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelos", new Modelo());//todosModelos);
		mv.addObject("listaCarros", new Carro());
		
		mv.addObject(new Cliente());
		
		return mv;
	}
	
	@RequestMapping(value = "/{idSelecionado}/pesquisaModelo", method = RequestMethod.GET)
	public @ResponseBody String preencherCampoModelo(@PathVariable Long idSelecionado) {
		String json = "";
		List<Modelo> listaMarca = modeloService.findAllModelosByIdMarca(idSelecionado);
		
		List<Object> list = listaMarca.stream()
					.map(o -> new Object[] {(Object) o})
					.collect(Collectors.toList());
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(list);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	
	
	//////////////////////
	
	@RequestMapping(value = "/pesquisarCliente",method=RequestMethod.GET) 
	public ModelAndView abrirPaginaPesquisa(@ModelAttribute("filtro") PesquisaClienteFilter nome) {
		List<Cliente> todosClientes = clienteService.filtrar(nome);
		ModelAndView mv = new ModelAndView("pesquisarCliente");
		mv.addObject("listaClientes",todosClientes);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/listBooks", method = RequestMethod.GET)
    public String listBooks(Model model, 
      @RequestParam("page") Optional<Integer> page, 
      @RequestParam("size") Optional<Integer> size) {
		
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Cliente> bookPage = clienteService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("bookPage", bookPage);

        int totalPages = bookPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "listaClientes";
    }
	/*
	public List<Cliente> buscarTodosClientes(){
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}*/
	
	
	@RequestMapping("{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = clienteService.findById(id);
		
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
