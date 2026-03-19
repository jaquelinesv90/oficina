package br.oficina.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "QRCODE")
public class QRCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pagamento")
	private Long id;
	
	@Column(name = "nome_beneficiario")
	private String nomeBeneficiario;
		
	@Column(name = "chave_pix")
	private String descricao;

	@Column(name="valor", precision = 19, scale = 2)
	private BigDecimal valor;
	
	@OneToOne
	@JoinColumn(name = "fk_chave_pix")
	private TipoChavePix tipoChavepix;
	
	@Column(name = "cidade_beneficiario")
	private String cidadeBeneficiario;
	
	@OneToOne
	@JoinColumn(name = "fk_mecanico")
	private Mecanico mecanico;
	
	@Lob
	@Column(name="imagem_qr_code")
	private byte[] imagemQrCode;
	
	@Column(name = "chave_copia_cola")
	private String chaveCopiaCola;
	

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoChavePix getTipoChavepix() {
		return tipoChavepix;
	}

	public void setTipoChavepix(TipoChavePix tipoChavepix) {
		this.tipoChavepix = tipoChavepix;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public byte[] getImagemQrCode() {
		return imagemQrCode;
	}

	public void setImagemQrCode(byte[] imagemQrCode) {
		this.imagemQrCode = imagemQrCode;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public String getCidadeBeneficiario() {
		return cidadeBeneficiario;
	}

	public void setCidadeBeneficiario(String cidadeBeneficiario) {
		this.cidadeBeneficiario = cidadeBeneficiario;
	}

	public String getChaveCopiaCola() {
		return chaveCopiaCola;
	}

	public void setChaveCopiaCola(String chaveCopiaCola) {
		this.chaveCopiaCola = chaveCopiaCola;
	}
	
}
