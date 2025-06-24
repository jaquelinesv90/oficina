package br.oficina.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ITEM_DESCRICAO")
public class ItemDescricao {

	@Id
	private Long id;
	
	private int item;
	
	private String descricao;

	private int quantidade;
	
	@Column(name = "valor_unitario", precision= 19, scale=2)
	private BigDecimal valorUnitario;
	
	@Transient
	@Column(precision= 19, scale=2)
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name="fk_orcamento")
	private Orcamento orcamento;
	
	public ItemDescricao(){}
	
	public ItemDescricao(Long id,String descricao,int quantidade) {
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
