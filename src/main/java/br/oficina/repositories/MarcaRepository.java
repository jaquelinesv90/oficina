package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {
	

}
