package br.oficina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.oficina.models.Usuario;
import br.oficina.repositories.UsuarioRepository;

@Service
public class UsuarioDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repository.findByEmail(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		return usuario;
	}
}
