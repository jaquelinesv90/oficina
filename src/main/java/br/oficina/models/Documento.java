package br.oficina.models;

import java.time.LocalDate;

import br.oficina.enumeradores.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_documento")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo;
	
	@Column(name = "nome_arquivo")
	private String nome;
	
	@Column(name = "tamanho_arquivo")
	private long tamanho;
	
	@Lob
	@Column(length = 1000)
	private byte[] conteudo;
	
	private String hash; 
	
	@Column(name = "data_upload")
	private LocalDate dataUpload;
	
	@ManyToOne
	@JoinColumn(name = "fk_mecanico")
	private Mecanico mecanico;
	
	
	public Documento(TipoDocumento tipoDocumento, String nome, long tamanho, byte[] conteudo, LocalDate dataUpload, String hash){
		this.tipo = tipoDocumento;
		this.nome = nome;
		this.tamanho = tamanho;
		this.conteudo = conteudo;
		this.dataUpload = dataUpload;
		this.hash = hash;
	}
	
	public Documento() {}

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

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDate getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(LocalDate dataUpload) {
		this.dataUpload = dataUpload;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	
}
