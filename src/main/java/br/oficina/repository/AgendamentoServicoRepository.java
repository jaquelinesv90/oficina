package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.model.AgendamentoServico;

public interface AgendamentoServicoRepository extends JpaRepository<AgendamentoServico,Long>{

}
