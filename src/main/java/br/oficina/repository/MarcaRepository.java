package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {
	

}
