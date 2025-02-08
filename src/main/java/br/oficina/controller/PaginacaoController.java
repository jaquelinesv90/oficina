package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.model.Cliente;
import br.oficina.service.ClienteService;

@Controller
public class PaginacaoController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/pesquisarCliente/pagina/{pageNum}")
	public String findPaginated( 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			@PathVariable (value = "pageNum") int pageNum,
			@ModelAttribute("filtro") PesquisaClienteFilter nome,
			Model model) {
			
		int pageSize = 3;
		
		Page<Cliente> page = clienteService.findPaginated(pageNum, pageSize,sortField, sortDir);
		List<Cliente> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listaClientes", listEmployees);
		
		return "pesquisarCliente";
	}


}
