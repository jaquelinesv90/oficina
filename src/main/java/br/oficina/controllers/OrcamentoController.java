package br.oficina.controllers;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.models.ItemDescricao;
import br.oficina.models.Marca;
import br.oficina.models.Modelo;
import br.oficina.models.Orcamento;
import br.oficina.service.JasperReportService;
import br.oficina.service.MarcaService;
import br.oficina.service.OrcamentoService;
import br.oficina.util.DateUtils;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	private static JasperReportService jasperReportService
			= new JasperReportService();
	
	@Autowired
	private OrcamentoService orcamentoService;
	
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		Orcamento orcamento = new Orcamento();
		List<Marca> todasMarcas = marcaService.findAll();
		
		orcamento.setDataEmissao(new Date());
		orcamento.setValidoAte(DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		orcamento.setNumOrcamento(orcamentoService.findNextSequence());
		
		ModelAndView mv = new ModelAndView("cadastrarOrcamento");
		
		mv.addObject("orcamento", orcamento);
		
		mv.addObject("listaMarcas", todasMarcas);
		mv.addObject("listaModelos", new Modelo());
		
		return mv;
	}

	@RequestMapping("/pesquisarOrcamento")
	public String  pesquisar(Model model) {
		////List<Orcamento> todosOrcamentos = orcamentoService.findAll();
		
		////ModelAndView mv = new ModelAndView("pesquisarOrcamentos");
		//mv.addObject("listaOrcamentos", todosOrcamentos);
		
		////return mv;
		
		return findPaginated("id","asc",1,model);
	}
	
	//fazer esse metodo generico
	//findPaginated( 1,"nome","asc",model);
	@GetMapping("/pesquisarOrcamento/pagina/{pageNum}")
	public String findPaginated( 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			@PathVariable (value = "pageNum") int pageNum,
			Model model) {
			
		int pageSize = 3;
		
		Page<Orcamento> page = orcamentoService.findPaginated(pageNum, pageSize,sortField, sortDir);
		List<Orcamento> listOrcamentos = page.getContent();
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listaOrcamentos", listOrcamentos);
		model.addAttribute("url","/orcamento/pesquisarOrcamento/pagina/");
		
		return "pesquisarOrcamentos";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Orcamento orcamento) {
		//orcamentoService.salvar(orcamento);
		ModelAndView mv = new ModelAndView();
		gerarPdf(orcamento);
		
		mv.addObject("mensagem","Orcamento salvo com sucesso");
		return mv;
	}
	
	
	public void gerarPdf(Orcamento orcamento) {
		
		String arquivo = "orcamentos/";
		String arquivoJrxml = "novo_orcamento.jrxml";
		
		Map<String,Object> params= new HashMap<>();
		
		params.put("numOrcamento", orcamento.getNumOrcamento());
		params.put("dataEmissao", orcamento.getDataEmissao());
		params.put("validoAte", orcamento.getValidoAte());
		params.put("nome", orcamento.getNome());
		params.put("endereco", orcamento.getEndereco());
		params.put("cidade", orcamento.getCidade());
		params.put("telefone", orcamento.getTelefone());
		params.put("email", orcamento.getEmail());
		params.put("estado", orcamento.getEstado());
		params.put("marca", orcamento.getMarca());
		//params.put("modelo", orcamento.getMarca().getModelos());
		params.put("ano", orcamento.getAno());
		params.put("placa", orcamento.getPlaca());
		params.put("observacao", orcamento.getObservacao());
		
		ItemDescricao item1 = new ItemDescricao();
		item1.setItem(1);
		item1.setDescricao("oleo de motor");
		item1.setQuantidade(3);
		item1.setValorUnitario(new BigDecimal(4.50));
		
		ItemDescricao item2 = new ItemDescricao();
		item2.setItem(2);
		item2.setDescricao("junta do cabecote");
		item2.setQuantidade(1);
		item2.setValorUnitario(new BigDecimal(50.00));
		
		ItemDescricao item3 = new ItemDescricao();
		item3.setItem(3);
		item3.setDescricao("cola de junta");
		item3.setQuantidade(1);
		item3.setValorUnitario(new BigDecimal(10.00));
		
		ItemDescricao item4 = new ItemDescricao();
		item4.setItem(4);
		item4.setDescricao("tampa do radidor");
		item4.setQuantidade(1);
		item4.setValorUnitario(new BigDecimal(110.00));
		
		ItemDescricao item5 = new ItemDescricao();
		item5.setItem(5);
		item5.setDescricao("retifica");
		item5.setQuantidade(1);
		item5.setValorUnitario(new BigDecimal(300.00));
		
		
		List<ItemDescricao> items = new ArrayList<ItemDescricao>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		
		JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(items);
		
		params.put("CollectionItems", collectionDataSource);

		
		try {
			
			jasperReportService.gerar(params,arquivo,arquivoJrxml);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
