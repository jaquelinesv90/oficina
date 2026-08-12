package br.oficina.util;

import java.math.BigDecimal;

public class GenericUtils {
	
	public static BigDecimal removeFormatacaoMonetaria(String valor) {
		String resultado = valor.replace("R$", "").replace(",", ".");
		
		return new BigDecimal(resultado);
	}

}


