package br.oficina.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class JasperReportService {
	

	public static String ARQUIVO = "";
	
	public static final String PREFIXO = "classpath:jasper/";
	
	private static String ARQUIVOJRXML = "";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JasperReportService.class);
	
	private static final String DESTINOPDF = "c:\\jasper-reports\\";
	
	
	public void gerar(Map<String,Object> object, String arquivo, String arquivoJrxml) throws FileNotFoundException {
		
		this.ARQUIVO = PREFIXO + arquivo;
		this.ARQUIVOJRXML = arquivoJrxml;
		
		String pathAbsolute = getAbsolutePath();
		
		try {
			String folderDiretorio = getDiretorioSave("novo_orcamento");
			
			JasperReport report = JasperCompileManager.compileReport(pathAbsolute);
			LOGGER.info("report compilado");
			JasperPrint print = JasperFillManager.fillReport(report,object,new JREmptyDataSource());
			LOGGER.info("jasper print");
			JasperExportManager.exportReportToPdfFile(print,folderDiretorio);
			
		}catch(JRException e) {
			throw new RuntimeException(e);
		}
	}

	private String getDiretorioSave(String name) {
		this.createDiretorio(DESTINOPDF);
		return DESTINOPDF + name.concat(".pdf");
	}

	private void createDiretorio(String name) {
		File dir = new File(name);
		if(!dir.exists()) {
			dir.mkdir();
		}
	}

	private String getAbsolutePath() throws FileNotFoundException {
		return ResourceUtils.getFile(ARQUIVO+ARQUIVOJRXML).getAbsolutePath();
	}

}
