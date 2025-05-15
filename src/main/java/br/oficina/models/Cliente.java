package br.oficina.models;

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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Proprietario")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_proprietario")
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf", unique = true)
	private String cpf;

	@Column(name = "celular")
	private String celular;

	@Column(name = "telefone")
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private List<Carro> carros;

	@NotNull
	@Column(name = "mecanico")
	private String mecanico;

	public Cliente() {}

	public Cliente(Long id, String nome, String cpf, String celular, String telefone, Endereco endereco,
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
	
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
