package br.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.enumeradores.StatusServico;
import br.oficina.models.AgendamentoServico;
import br.oficina.repositories.AgendamentoServicoRepository;

@Service
public class AgendamentoServicoService {
	
	@Autowired
	AgendamentoServicoRepository repository;
	
	public List<AgendamentoServico> findAll(){
		return repository.findAll();
	}
	
	public List<AgendamentoServico> findAgendamentosByDataServico(String data){
		
		return repository.findAgendamentosByDataServico(data);
	}
	
	public String marcarServicoComoFeito(Long id) {
		Optional<AgendamentoServico> agendamento = repository.findById(id);
		agendamento.get().setStatusServico(StatusServico.FEITO);
		repository.save(agendamento.get());
		
		return StatusServico.FEITO.getDescricao();
	}
	
	public List<AgendamentoServico> pesquisar(String nome){
		return repository.findAgendamentosByNomeCliente(nome);
	}
	
	public AgendamentoServico getOne(Long id) {
		return repository.findById(id).get();
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
