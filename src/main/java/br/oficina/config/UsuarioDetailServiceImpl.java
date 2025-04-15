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
	private UsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario u = ur.findByEmail(username);
		
		if(u == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		
		return u;
	}

}
