package br.oficina.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.oficina.models.ItemDescricao;
import br.oficina.models.Marca;
import br.oficina.models.Modelo;
import br.oficina.models.NumeroOrcamento;
import br.oficina.models.Orcamento;
import br.oficina.models.Usuario;
import br.oficina.repositories.OrcamentoRepository;
import br.oficina.service.MarcaService;
import br.oficina.service.MecanicoService;
import br.oficina.service.NumeroOrcamentoService;
import br.oficina.service.OrcamentoService;
import br.oficina.service.PaginacaoService;
import br.oficina.util.DateUtils;
import br.oficina.util.OficinaHelper;

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
	
	@Autowired
	private MecanicoService mecanicoService;
	
	@Autowired
	private NumeroOrcamentoService numeroOrcamentoService;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		Orcamento orcamento = new Orcamento();
		List<Marca> todasMarcas = marcaService.findAll();
		
		orcamento.setValidoAte(DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		
		orcamento.setNumOrcamento(new NumeroOrcamento());
		orcamento.getNumOrcamento().setNumOrcamento(getNumOrcamento());
			
		ModelAndView mv = new ModelAndView("cadastrarOrcamento");
		
		Usuario principal = OficinaHelper.setUsuarioLogado();
		
		orcamento.setItens(new ArrayList<>());
		
		IntStream.range(0, 6).forEach(i -> orcamento.getItens().add(new ItemDescricao()));
		IntStream.range(0, 6).forEach(i -> orcamento.getItens().get(i).setItem(i));
		
		mv.addObject("mecanico", principal.getNome());
		mv.addObject("dataEmissao", new Date());
		mv.addObject("validoAte", DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelos", new Modelo());
		mv.addObject("itens",orcamento.getItens());
		mv.addObject("orcamento", orcamento);
		
		return mv;
	}
	
	public Long getNumOrcamento() {
		return  orcamentoService.nextValue();
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
		
		Usuario principal = OficinaHelper.setUsuarioLogado();
		orcamento.setMecanico(mecanicoService.findById(principal.getId()));
		
		if(orcamento.getItens() != null) {
			for(ItemDescricao item : orcamento.getItens()) {
				System.out.println("ITEM " + item.getItem());
				System.out.println("DESCRICAO " + item.getDescricao());
				System.out.println("QUANTIDADE  " + item.getQuantidade());
				System.out.println("PRECO  " + item.getValorUnitario());
			}
		}
		
		orcamento.setNumOrcamento(new NumeroOrcamento());
		orcamento.getNumOrcamento().setNumOrcamento(getNumOrcamento());
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
	
	
}
