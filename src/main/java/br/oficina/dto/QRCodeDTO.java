package br.oficina.dto;

public class QRCodeDTO {
	
	private String nomeBeneficiario;
	private String cidadeBeneficiario;
	private String chaveCopiaCola;
	private String descricao;
	private String tipoChavepix;
	private String valor;
	
	public QRCodeDTO() {}
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoChavepix() {
		return tipoChavepix;
	}

	public void setTipoChavepix(String tipoChavepix) {
		this.tipoChavepix = tipoChavepix;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "QRCodeDTO{"
				+ "nomeBeneficiario'" + nomeBeneficiario +
				"',valor='" + valor +"'"
						+ "tipoChavepix"
						+ "cidadeBeneficiario"
						+ "chaveCopiaCola"
						+ "}";
	}
}
