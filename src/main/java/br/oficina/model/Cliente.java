package br.oficina.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proprietario")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_proprietario")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private Long cpf;

	@Column(name = "celular")
	private BigDecimal celular;

	@Column(name = "telefone")
	private BigDecimal telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private List<Carro> carros;

	@Column(name = "mecanico")
	private String mecanico;

	public Cliente() {
	}

	public Cliente(Long id, String nome, Long cpf, BigDecimal celular, BigDecimal telefone, Endereco endereco,
			List<Carro> carros, String mecanico) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.telefone = telefone;
		this.endereco = endereco;
		this.carros = carros;
		this.mecanico = mecanico;
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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

	public BigDecimal getCelular() {
		return celular;
	}

	public void setCelular(BigDecimal celular) {
		this.celular = celular;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public BigDecimal getTelefone() {
		return telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}
}
