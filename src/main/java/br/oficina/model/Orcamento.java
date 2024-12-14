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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_orcamento")
	private Long id;
	
	@Column(name = "numero_orcamento")
	private int numOrcamento;
	
	@Column(name = "nome_cliente")
	private String nome;
	
	private String endereco;
	
	private String cidade;
	
	private String estado;
	
	private String email;
	
	private String telefone;
	
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
	
	@Transient
	private Date validoAte;

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

	public Date getValidoAte() {
		return validoAte;
	}

	public void setValidoAte(Date validoAte) {
		this.validoAte = validoAte;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
