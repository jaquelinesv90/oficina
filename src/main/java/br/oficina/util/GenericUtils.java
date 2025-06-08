package br.oficina.util;

import java.math.BigDecimal;

public class GenericUtils {
	
	public static BigDecimal removeFormatacaoMonetaria(String valor) {
		String resultado = valor.replaceAll("R\\$", "");
		
		return new BigDecimal(resultado);
	}

}


