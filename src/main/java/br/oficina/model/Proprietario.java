package br.oficina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_proprietario",updatable = false, nullable = false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private Long cpf;
	
	@Column(name="celular")
	private Long celular;
	
	@Column(name="residencial")
	private Long residencial;
	
	@OneToOne
	@JoinColumn(name="fk_endereco")
	private Endereco endereco;
	
	@Column(name="mecanico")
	private String mecanico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Long getResidencial() {
		return residencial;
	}

	public void setResidencial(Long residencial) {
		this.residencial = residencial;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getMecanico() {
		return mecanico;
	}

	public void setMecanico(String mecanico) {
		this.mecanico = mecanico;
	}

}
