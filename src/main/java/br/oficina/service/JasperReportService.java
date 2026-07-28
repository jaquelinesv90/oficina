package br.oficina.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    private static final String PREFIXO = "classpath:jasper/";
    private static final String DESTINOPDF = "src/main/resources/pdfs/orcamentos/";
    private static final Logger LOGGER = LoggerFactory.getLogger(JasperReportService.class);

    public String salvarNoDiretorio(Map<String, Object> params, String arquivo,
                                     Long numOrcamento, String arquivoJrxml) throws FileNotFoundException {
        String arquivoJrxmlPath = ResourceUtils
                .getFile(PREFIXO + arquivo + arquivoJrxml)
                .getAbsolutePath();

        // Cria a pasta se não existir
        File pasta = new File(DESTINOPDF);
        if (!pasta.exists()) pasta.mkdirs(); // mkdirs cria subpastas também

        // Nome simples e direto
        String caminhoFinal = DESTINOPDF + "orcamento_" + numOrcamento + ".pdf";

        try {
            JasperReport report = JasperCompileManager.compileReport(arquivoJrxmlPath);
            LOGGER.info("Report compilado");
            JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
            LOGGER.info("Jasper print gerado");
            JasperExportManager.exportReportToPdfFile(print, caminhoFinal);
            LOGGER.info("PDF salvo em: {}", caminhoFinal);

            return caminhoFinal; // ex: src/main/resources/pdfs/orcamentos/orcamento_1006.pdf
        } catch (JRException e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
    }

    public ResponseEntity<byte[]> abrirPdf(String numOrcamento) throws IOException {
        // Monta o caminho com o número do orçamento
        String caminho = DESTINOPDF + "orcamento_" + numOrcamento + ".pdf";
        Path path = Paths.get(caminho);

        LOGGER.info("Lendo PDF em: {}", caminho);

        if (!Files.exists(path)) {
            LOGGER.error("PDF não encontrado: {}", caminho);
            return ResponseEntity.notFound().build();
        }

        byte[] pdf = Files.readAllBytes(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.add("Content-Disposition", "inline; filename=orcamento_" + numOrcamento + ".pdf");

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
