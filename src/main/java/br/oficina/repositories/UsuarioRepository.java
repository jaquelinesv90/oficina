package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);

}
