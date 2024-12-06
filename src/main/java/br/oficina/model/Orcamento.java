package br.oficina.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_orcamento")
	private Long id;
	
	@SequenceGenerator(name = "seqNumOrcamento",sequenceName="SQ_NUMERO_ORCAMENTO",
				allocationSize = 1)
	@Column(name = "numero_orcamento")
	private int numOrcamento;
	
	@Column(name = "nome_cliente")
	private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_emissao")
	private Date dataEmissao;
	
	@Column(name = "carro_ano")
	private int ano;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "valor_mao_obra")
	private BigDecimal valorMaoObra;
	
	@Column(name = "mecanico")
	private String mecanico;
	
	@OneToMany(mappedBy = "orcamento")
	private List<ItemDescricao> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumOrcamento() {
		return numOrcamento;
	}

	public void setNumOrcamento(int numOrcamento) {
		this.numOrcamento = numOrcamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValorMaoObra() {
		return valorMaoObra;
	}

	public void setValorMaoObra(BigDecimal valorMaoObra) {
		this.valorMaoObra = valorMaoObra;
	}

	public String getMecanico() {
		return mecanico;
	}

	public void setMecanico(String mecanico) {
		this.mecanico = mecanico;
	}

	public List<ItemDescricao> getItems() {
		return items;
	}

	public void setItems(List<ItemDescricao> items) {
		this.items = items;
	}
		
}
