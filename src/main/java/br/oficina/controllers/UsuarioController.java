package br.oficina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.oficina.models.Usuario;
import br.oficina.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
		
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/form")
	public String form() {
		return "site/esqueciSenha";
	}
	
	@PostMapping
	public String editar(Usuario usuario) {
		
		Usuario usuarioEditado = new Usuario();
		
		usuarioEditado = service.findByEmail(usuario.getEmail());
		
		String senha = usuario.getSenha();
		String senhaCrypto = new BCryptPasswordEncoder().encode(senha);
		usuarioEditado.setSenha(senhaCrypto);	
		
		service.update(usuarioEditado);
		
		return "redirect:/login";
	}
}
