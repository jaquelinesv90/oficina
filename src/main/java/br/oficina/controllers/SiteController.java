package br.oficina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.models.AgendamentoServico;
import br.oficina.models.Usuario;
import br.oficina.service.AgendamentoServicoService;
import br.oficina.service.UsuarioService;
import br.oficina.util.DateUtils;

@Controller
public class SiteController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AgendamentoServicoService agendamentoService;
	
	
	@GetMapping("/")
	public ModelAndView index(@AuthenticationPrincipal UserDetails userDetails) {
			
		Usuario user = usuarioService.findByEmail(userDetails.getUsername());
			
		String dataAtual = DateUtils.getDataAtual();
		String dataAtualFormatada = DateUtils.getDataAtualFormatada();
			
		List<AgendamentoServico> listaAgendamento = agendamentoService.findAgendamentosByDataServico(dataAtualFormatada);
					
		ModelAndView mv = new ModelAndView("site/index");
		mv.addObject("listaclientes", listaAgendamento);
		mv.addObject("dataAtual", dataAtual);
		mv.addObject("user",user); 
			
		return mv;
	}
	
	@GetMapping("/pesquisar")
	public String pesquisar() {
		return "pesquisar";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login/logout";
	}
}
