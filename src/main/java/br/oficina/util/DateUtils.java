package br.oficina.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	public static String getDataAtualFormatada(Date dataAtual) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return dateFormat.format(dataAtual);
	}
	
	public static Date calcula30Dias(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE,30);
		Date dateAfter30Days = calendar.getTime();
		
		return dateAfter30Days;
	}
}
