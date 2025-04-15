package br.oficina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.oficina.models.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo,Long>{
	
	@Query(value="select m from Modelo m join m.marca mar where mar.id = ?1 ")
	List<Modelo> findAllModelosByIdMarca(Long id);
		
}
