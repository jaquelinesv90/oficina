package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.oficina.models.Orcamento;
import br.oficina.repositories.OrcamentoRepository;

@Service
public class OrcamentoService {
	
	@Autowired
	private OrcamentoRepository repository;
	
	public List<Orcamento> findAll(){
		return repository.findAll();
	}
	
	public void salvar(Orcamento orcamento) {
		repository.save(orcamento);
	}
	
	public int findNextSequence() {
		return repository.findNextSequence();
	}
	
	
	public Page<Orcamento> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.repository.findAll(pageable);
	}

}
