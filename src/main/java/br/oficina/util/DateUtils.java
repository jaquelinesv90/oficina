package br.oficina.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

public class DateUtils {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("['HH:mm']['hh:mm a']");

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
	//era pra ser usado no agendamento de servico, converter a hora
	public static LocalTime convertHoraToEntityFromDb(String dbData) {
		return dbData != null ? LocalTime.parse(dbData, FORMATTER) : null;
	}
		
}
