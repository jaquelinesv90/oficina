package br.oficina.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.models.Marca;
import br.oficina.models.Modelo;
import br.oficina.models.Orcamento;
import br.oficina.models.Usuario;
import br.oficina.repositories.OrcamentoRepository;
import br.oficina.service.MarcaService;
import br.oficina.service.OrcamentoService;
import br.oficina.service.PaginacaoService;
import br.oficina.util.DateUtils;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	@Autowired
	private OrcamentoService orcamentoService;
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Autowired
	private PaginacaoService paginacaoService;
	
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		Orcamento orcamento = new Orcamento();
		List<Marca> todasMarcas = marcaService.findAll();
		
		orcamento.setValidoAte(DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		orcamento.setNumOrcamento(orcamentoService.nextSequenceValue());
			
		ModelAndView mv = new ModelAndView("cadastrarOrcamento");
		
		mv.addObject("dataEmissao", new Date());
		mv.addObject("validoAte", DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		
		Usuario principal = setUsuarioLogado();
		mv.addObject("mecanico", principal.getNome());
		
		mv.addObject("orcamento", orcamento);
		
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelos", new Modelo());
		
		return mv;
	}

	@RequestMapping(value = "/pesquisarOrcamento",method=RequestMethod.GET) 
	public String pesquisarCliente(@ModelAttribute("filtro") PesquisaClienteFilter nome, Model model) {
		
		return findPaginated("nome","asc",1,nome,model);
	}
	
	@GetMapping("/pesquisarOrcamento/pagina/{pageNum}")
	public String findPaginated( 
		@RequestParam("sortField") String sortField,
		@RequestParam("sortDir") String sortDir,
		@PathVariable (value = "pageNum") int pageNum,
		@ModelAttribute("filtro") PesquisaClienteFilter nome,
		Model model) {
					
		model = paginacaoService.findPaginated(
				sortField, sortDir, pageNum, model, orcamentoRepository);
				
		model.addAttribute("listaOrcamentos",  model.getAttribute("lista"));
		model.addAttribute("url","/orcamento/pesquisarOrcamento/pagina/");
				
		return "pesquisarOrcamento";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Orcamento orcamento) {
		orcamento.setDataEmissao(new Date());
		orcamento.setValidoAte( DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		
		Usuario principal = setUsuarioLogado();
		orcamento.setMecanico(principal.getNome());
		
		orcamentoService.salvar(orcamento);
		ModelAndView mv = new ModelAndView("cadastrarOrcamento");
		
		gerarPdf(orcamento);
		
		mv.addObject("mensagem","Orçamento salvo com sucesso");
		return mv;
	}
	
	public void gerarPdf(Orcamento orcamento) {
		
		String arquivo = "orcamentos/";
		String arquivoJrxml = "novo_orcamento.jrxml";
		
		orcamentoService.gerarPdf(orcamento, arquivo, arquivoJrxml);
	}
	
	private Usuario setUsuarioLogado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario principal = (Usuario)authentication.getPrincipal();
		return principal;
	}
}
