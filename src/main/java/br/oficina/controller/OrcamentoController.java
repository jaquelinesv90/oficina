package br.oficina.controller;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.Orcamento;
import br.oficina.repository.OrcamentoRepository;
import br.oficina.service.JasperReportService;
import br.oficina.service.OrcamentoService;
import br.oficina.utils.DateUtils;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Autowired
	private OrcamentoService orcamentoService;
	
	private final JasperReportService jasperReportService = new JasperReportService();
	
	@RequestMapping("/pesquisarOrcamento")
	public ModelAndView  listar() {
		List<Orcamento> todosOrcamentos = orcamentoRepository.findAll();
		
		ModelAndView mv = new ModelAndView("pesquisarOrcamentos");
		mv.addObject("listaOrcamentos", todosOrcamentos);
		
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		Orcamento orcamento = new Orcamento();
		
		orcamento.setDataEmissao(Calendar.getInstance().getTime());
		orcamento.setValidoAte(DateUtils.calcula30Dias(orcamento.getDataEmissao()));
		
		ModelAndView mv = new ModelAndView("cadastrarOrcamento");
		mv.addObject("dtEmissao", orcamento.getDataEmissao());
		mv.addObject("validoAte", orcamento.getValidoAte());
		mv.addObject("numOrcamento", orcamento.getNumOrcamento());
		
		return mv;
	}

	
	
	@PostMapping
	public void gerarPdf(Orcamento orcamento) {
		try {
			this.jasperReportService.gerar(orcamento);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
