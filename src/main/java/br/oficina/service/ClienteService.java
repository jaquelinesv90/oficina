package br.oficina.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.model.Cliente;
import br.oficina.repository.ClienteRepository;

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
	
	 final private List<Cliente> books = new ArrayList<>();

	    public Page<Cliente> findPaginated(Pageable pageable) {
	        int pageSize = pageable.getPageSize();
	        int currentPage = pageable.getPageNumber();
	        int startItem = currentPage * pageSize;
	        List<Cliente> list;

	        if (books.size() < startItem) {
	            list = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, books.size());
	            list = books.subList(startItem, toIndex);
	        }

	        Page<Cliente> bookPage = new PageImpl<Cliente>(list, PageRequest.of(currentPage, pageSize), books.size());

	        return bookPage;

	    }

}
