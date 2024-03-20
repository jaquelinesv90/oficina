package br.oficina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServicoPrestado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_servico_prestado",updatable = false, nullable = false)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@Column(name="preco_tabela")
	private String precoTabela;
	
	public ServicoPrestado() {}
	
	public ServicoPrestado(String nome,String descricao, String precoTabela) {
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

	public String getPrecoTabela() {
		return precoTabela;
	}

	public void setPrecoTabela(String precoTabela) {
		this.precoTabela = precoTabela;
	}
}
