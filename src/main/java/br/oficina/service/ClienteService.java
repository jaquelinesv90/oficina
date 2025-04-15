package br.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.models.Cliente;
import br.oficina.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> filtrar(PesquisaClienteFilter filtro){
		String nome = filtro.getNome() == null ? "" : filtro.getNome();
		return repository.findByNomeContaining(nome);
	}
	
	public List<Cliente> findByNomeContaining(String nome){
		return repository.findByNomeContaining(nome);
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.get();
	}
	
	public void salvar(Cliente cliente) {
		repository.save(cliente);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	public Page<Cliente> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.repository.findAll(pageable);
	}
}
