package br.oficina.dto;

public class QRCodeDTO {
	
	private String nome;
	private String cidade;
	private String chaveCopiaCola;
	//private String descricao;
	private String tipoChavepix;
	private String valor;
	//private String mecanico;
	//private byte[] imagemQrCode;
	
	
	public QRCodeDTO() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getChaveCopiaCola() {
		return chaveCopiaCola;
	}
	public void setChaveCopiaCola(String chaveCopiaCola) {
		this.chaveCopiaCola = chaveCopiaCola;
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
				+ "nomeBeneficiario'" + nome+
				"',valor='" + valor +"'"
						+ "tipoChavepix"
						+ "cidadeBeneficiario"
						+ "chaveCopiaCola"
						+ "}";
	}
}
