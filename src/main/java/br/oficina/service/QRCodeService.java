package br.oficina.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import br.oficina.models.QRCode;
import br.oficina.qrcode.DadosEnvioPix;
import br.oficina.qrcode.QRCodePix;
import br.oficina.repositories.QRCodeRepository;

@Service
public class QRCodeService {
	
	@Autowired
	private QRCodeRepository repository;
	
	public List<QRCode>  findAll(){
		return repository.findAll();
	}
	
	public void salvar(QRCode qrcode) {
		repository.save(qrcode);
	}
	
    // Driver code
    public QRCode gerarQrCode(QRCode qrcode) {
    	
    	 final var imagePath = "C:\\workspace\\QRCodes\\qrcode.png";

         final var dadosPix =
                 new DadosEnvioPix(
                         qrcode.getNomeBeneficiario(), qrcode.getDescricao(),
                        qrcode.getValor(), qrcode.getCidadeBeneficiario(), "Pagamento Mecanica Leonildo");

         final var qrCodePix = new QRCodePix(dadosPix);
         //qrCodePix.save(Path.of(imagePath));
         
         qrcode.setImagemQrCode(qrCodePix.saveAndGetBytes(Path.of(imagePath)));
         
         System.out.println("QRCode:");
         System.out.println(qrCodePix);
         System.out.printf("%nArquivo gerado em " + imagePath);
         
         return qrcode;   
    }
}
