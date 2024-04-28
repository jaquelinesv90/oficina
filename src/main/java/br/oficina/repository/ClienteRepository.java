package br.oficina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	Optional<Cliente> findByNome(String nome);
	
}
