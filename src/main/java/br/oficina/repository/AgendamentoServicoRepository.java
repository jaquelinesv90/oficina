package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.model.AgendamentoServico;

@Repository
public interface AgendamentoServicoRepository extends JpaRepository<AgendamentoServico,Long>{

}
