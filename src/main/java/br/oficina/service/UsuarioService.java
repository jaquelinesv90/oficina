package br.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.Usuario;
import br.oficina.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

}
