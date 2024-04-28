package br.oficina.enumeradores;

public enum StatusServico {
	
	FEITO("Feito"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	StatusServico(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
