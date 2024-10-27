package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.model.Orcamento;


public interface OrcamentoRepository extends JpaRepository<Orcamento,Long>{

}
