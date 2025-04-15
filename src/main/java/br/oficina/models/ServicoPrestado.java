package br.oficina.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Servico_Prestado")
public class ServicoPrestado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_servico_prestado")
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@Column(name="preco_tabela")
	private BigDecimal precoTabela;
	
	public ServicoPrestado() {}
	
	public ServicoPrestado(String nome,String descricao, BigDecimal precoTabela) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoTabela = precoTabela;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoTabela() {
		return precoTabela;
	}

	public void setPrecoTabela(BigDecimal precoTabela) {
		this.precoTabela = precoTabela;
	}
}
