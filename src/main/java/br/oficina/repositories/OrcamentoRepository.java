package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.oficina.models.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento,Long>{
	
	@Query(value="SELECT * FROM num_orcamento", nativeQuery = true)
	Long nextValue();
}
