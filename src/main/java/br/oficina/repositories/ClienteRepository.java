package br.oficina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	List<Cliente> findByNomeContaining(String nome);
}
