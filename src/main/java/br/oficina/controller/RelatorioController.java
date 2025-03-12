package br.oficina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.oficina.model.Orcamento;
import br.oficina.service.JasperReportService;



@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	private final JasperReportService jasperReportService = new JasperReportService();
	
	@RequestMapping("/novo")
	public String novo() {
		return "relatorio.html";
	}
	
	@RequestMapping("/mensal")
	public String mensal() {
		return "relatorioMensal.html";
	}
	
	@PostMapping
	public void gerarPdf(Orcamento orcamento) {
	 /*	
		
		try {
			this.jasperReportService.gerar(orcamento);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
	}

}
