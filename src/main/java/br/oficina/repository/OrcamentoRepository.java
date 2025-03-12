package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.oficina.model.Orcamento;


public interface OrcamentoRepository extends JpaRepository<Orcamento,Long>{
	
	@Query(value=" SELECT  NEXTVAL(sq_numero_orcamento) ",nativeQuery = true)
	public int findNextSequence();

}
