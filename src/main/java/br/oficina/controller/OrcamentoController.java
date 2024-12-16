package br.oficina.controller;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.oficina.model.Orcamento;
import br.oficina.repository.OrcamentoRepository;
import br.oficina.service.JasperReportService;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	private final JasperReportService jasperReportService = new JasperReportService();
	
	@RequestMapping("/pesquisarOrcamento")
	public ModelAndView  listar() {
		List<Orcamento> todosOrcamentos = orcamentoRepository.findAll();
		
		ModelAndView mv = new ModelAndView("pesquisarOrcamentos");
		mv.addObject("listaOrcamentos", todosOrcamentos);
		
		return mv;
	}
	
	@RequestMapping("/novo")
	public String novo() {
		Orcamento orcamento = new Orcamento();
		
		orcamento.setDataEmissao(Calendar.getInstance().getTime());
		
		// orcamento.setValidoAte(Calendar.DATE,30);
		// setar campo validoAte
		return "cadastrarOrcamento";
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
