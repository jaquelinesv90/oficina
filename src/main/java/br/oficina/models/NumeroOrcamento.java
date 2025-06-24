package br.oficina.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "num_orcamento")
public class NumeroOrcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_num_orcamento")
	private Long id;
	
	@Column(name = "num_orcamento")
	private Long numOrcamento;
	
	@OneToOne(mappedBy ="numOrcamento")
	private Orcamento orcamento;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumOrcamento() {
		return numOrcamento;
	}

	public void setNumOrcamento(Long numOrcamento) {
		this.numOrcamento = numOrcamento;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
}
