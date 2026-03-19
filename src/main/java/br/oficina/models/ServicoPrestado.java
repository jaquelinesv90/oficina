package br.oficina.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Servico_Prestado")
public class ServicoPrestado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_servico_prestado")
	private Long id;
	
	private String descricao;
	
	@Column(name="preco_tabela")
	private BigDecimal precoTabela;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_servico")
	private TipoServico tipoServico;
	
	public ServicoPrestado() {}
	
	public ServicoPrestado(String descricao, BigDecimal precoTabela) {
		this.descricao = descricao;
		this.precoTabela = precoTabela;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	
}
