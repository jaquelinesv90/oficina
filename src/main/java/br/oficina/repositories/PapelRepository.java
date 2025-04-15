package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.models.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long>{
	
	Papel findByNome(String nome);

}
