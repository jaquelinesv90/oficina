package br.oficina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.oficina.models.AgendamentoServico;

@Repository
public interface AgendamentoServicoRepository extends JpaRepository<AgendamentoServico,Long>{
	
	@Query(value="select a from AgendamentoServico a join cliente c \r\n"
			+ "where c.id = a.cliente.id \r\n"
			+ "and c.nome like '%?1%'")
	List<AgendamentoServico> findAgendamentosByNomeCliente(String nome);
	
	@Query(value="select * from agendamento_servico  \r\n"
			+ "where data_servico = :data", nativeQuery = true)
	List<AgendamentoServico> findAgendamentosByDataServico(String data);


}
