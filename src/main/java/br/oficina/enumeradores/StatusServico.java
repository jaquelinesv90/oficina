package br.oficina.enumeradores;

public enum StatusServico {
	
	FEITO("Feito"),
	NAO_FEITO("Não Feito"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	StatusServico(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
