package br.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.model.Cliente;
import br.oficina.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> filtrar(PesquisaClienteFilter filtro){
		String nome = filtro.getNome() == null ? " " : filtro.getNome();
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

}
