package br.oficina.enumeradores;

public enum FormaPagamento {

	PIX("Pix"),
	DINHEIRO("Dinheiro");
	
	private String descricao;
	
	FormaPagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
