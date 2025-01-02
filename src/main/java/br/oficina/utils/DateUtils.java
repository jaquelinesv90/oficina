package br.oficina.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getDataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date();

		return dateFormat.format(dataAtual);
	}
	
	public static String getDataAtualFormatada() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dataAtual = new Date();

		return dateFormat.format(dataAtual);
	}
	
	public static Date calcula30Dias() {
		return new Date();
	}
}
