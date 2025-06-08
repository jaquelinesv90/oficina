package br.oficina.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.oficina.models.Usuario;

public class OficinaHelper {
	
	public static Usuario setUsuarioLogado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario principal = (Usuario)authentication.getPrincipal();
		return principal;
	}
}
