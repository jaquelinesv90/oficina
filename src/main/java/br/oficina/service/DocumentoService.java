package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.oficina.models.Cliente;
import br.oficina.models.Documento;
import br.oficina.repositories.DocumentoRepository;

@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository repository;
	
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	
	public void salvar(Documento documento) {
		
		repository.save(documento);
	}
	
	public Documento findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Documento> findAll(){
		return repository.findAll();
	}
	
	public Page<Documento> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.repository.findAll(pageable);
	}
	
}
