package br.oficina.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.enumeradores.TipoDocumento;
import br.oficina.models.Carro;
import br.oficina.models.Cliente;
import br.oficina.models.Documento;
import br.oficina.models.Mecanico;
import br.oficina.models.Usuario;
import br.oficina.service.DocumentoService;
import br.oficina.util.OficinaHelper;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {
	
	@Autowired
	private DocumentoService service;
	
	@GetMapping
	public ModelAndView list() {
		
		ModelAndView mv = new ModelAndView("pesquisarDocumentos");
		
		mv.addObject("listaDocumentos", new ArrayList<>());
		
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("cadastrarDocumento");
		mv.addObject("listaTipos",TipoDocumento.values());
		mv.addObject(new Documento());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Documento documento) {
		
		
		
		
		service.salvar(documento);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("mensagem","Documento salvo com sucesso");
		return mv;
	}
	
}
