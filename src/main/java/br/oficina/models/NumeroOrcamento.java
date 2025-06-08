package br.oficina.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "num_orcamento")
public class NumeroOrcamento {
	
	@Id
	@Column(name = "num_orcamento")
	private Long numOrcamento;
	
	@OneToOne(mappedBy ="numOrcamento")
	private Orcamento orcamento;

	public Long getNumOrcamento() {
		return numOrcamento;
	}

	public void setNumOrcamento(Long numOrcamento) {
		this.numOrcamento = numOrcamento;
	}
}
