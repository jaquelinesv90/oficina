package br.oficina.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.oficina.models.Orcamento;
import br.oficina.repositories.OrcamentoRepository;

@Service
public class OrcamentoService {
	
	private static JasperReportService jasperReportService
					= new JasperReportService();
	
	@Autowired
	private OrcamentoRepository repository;
	
	public List<Orcamento> findAll(){
		return repository.findAll();
	}
	
	public void salvar(Orcamento orcamento) {
		repository.save(orcamento);
	}
	
	public Long nextValue() {
		Long nextValue = repository.nextValue();
		return nextValue == null ? 1000L : nextValue + 1;
	}
		
	public Page<Orcamento> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.repository.findAll(pageable);
	}
	
	// Só monta os params e chama o jasper — sem lógica de arquivo aqui
	public void gerarPdf(Orcamento orcamento) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("numOrcamento",   orcamento.getNumOrcamento().getNumOrcamento());
	    params.put("dataEmissao",    orcamento.getDataEmissao());
	    params.put("validoAte",      orcamento.getValidoAte());
	    params.put("nome",           orcamento.getNome());
	    params.put("endereco",       orcamento.getEndereco());
	    params.put("cidade",         orcamento.getCidade());
	    params.put("telefone",       orcamento.getTelefone());
	    params.put("email",          orcamento.getEmail());
	    params.put("estado",         orcamento.getEstado());
	    params.put("marca",          orcamento.getMarca().getNome());
	    params.put("modelo",         orcamento.getModelo().getNome());
	    params.put("ano",            orcamento.getAno());
	    params.put("cor",            orcamento.getCor());
	    params.put("placa",          orcamento.getPlaca());
	    params.put("observacao",     orcamento.getObservacao());
	    params.put("mecanico",       orcamento.getMecanico().getNome());
	    params.put("totalGeral",     orcamento.getTotalGeral());
	    params.put("CollectionItems",orcamento.getItens());

	    try {
	        jasperReportService.salvarNoDiretorio(
	            params,
	            "orcamentos/",
	            orcamento.getNumOrcamento().getNumOrcamento(),
	            "orcamento.jrxml"
	        );
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException("Erro ao gerar PDF", e);
	    }
	}
	
	public ResponseEntity<byte[]> abrirPdf(String numOrcamento){
		try {
			return jasperReportService.abrirPdf(numOrcamento);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
