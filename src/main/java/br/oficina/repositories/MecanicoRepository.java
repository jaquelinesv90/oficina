package br.oficina.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
	
	Optional<Mecanico> findById(Long id);

}
