package br.oficina.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.oficina.models.Papel;
import br.oficina.models.Usuario;
import br.oficina.repositories.PapelRepository;
import br.oficina.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	
	
	
	
	////// apagar os metodos
	
	@PostMapping
	public String salvar(Usuario usuario) {

		String senha = usuario.getSenha();
		String senhaCrypto = new BCryptPasswordEncoder().encode(senha);
		
		usuario.setSenha(senhaCrypto);
		
		Papel p = papelRepository.findByNome("ROLE_VENDAS");
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(p);
		usuario.setPapeis(papeis);
		
		
		System.out.println(usuario);

		usuarioRepository.save(usuario);
		
		return "redirect:/"; 
	}
	
}
