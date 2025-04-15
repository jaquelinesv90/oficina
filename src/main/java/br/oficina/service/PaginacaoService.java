package br.oficina.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class PaginacaoService {
	
	public<T, ID> Model findPaginated( 
			String sortField, String sortDir,
			int pageNum, Model model,
			JpaRepository<T,ID> repository) {
			
		int pageSize = 5;
		
		Page<T> page = findPaginated(pageNum, pageSize,sortField, sortDir,repository);
		List<T> result = (List<T>) getContent(page);	
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("lista", result);
		
		return model;
	}
	
	public<T> List<T> getContent(Page<T> page){
		return  page.getContent();
	}
	
	public<T,ID> Page findPaginated(int pageNo, int pageSize, String sortField, String sortDirection,
			JpaRepository<T,ID> repository) {
		
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		Page<T> entidade = repository.findAll(pageable);
		
		return entidade;
	}
}
