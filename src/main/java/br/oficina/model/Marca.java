package br.oficina.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_marca")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	public Marca() {}

	public Marca(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
