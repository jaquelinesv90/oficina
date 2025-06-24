package br.oficina.enumeradores;

public enum TipoDocumento {
	
	CONTRATO("Contrato"), 
	TABELA_PRECOS("Tabela de Preço");
	
	private String descricao;
	
	TipoDocumento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
