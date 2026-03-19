package br.oficina.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.dto.QRCodeDTO;
import br.oficina.models.QRCode;
import br.oficina.qrcode.DadosEnvioPix;
import br.oficina.qrcode.QRCodePix;
import br.oficina.repositories.QRCodeRepository;
import br.oficina.util.ConverterUtil;

@Service
public class QRCodeService {
	
	@Autowired
	private QRCodeRepository repository;
	
	@Autowired
	private ConverterUtil converter;
	
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
         qrcode.setChaveCopiaCola(qrCodePix.toString());
         System.out.println("Copia e Cola: " + qrCodePix);
         
         System.out.println("QRCode:");
         System.out.println(qrCodePix);
         System.out.printf("%nArquivo gerado em " + imagePath);
         
         return qrcode;   
    }
    
    //// metodo de teste -apagar depois
    public QRCode gerarQrCodeTeste(QRCodeDTO qrcodeDto) {
    	
       QRCode qrcode = converter.convert(qrcodeDto, QRCode.class);	
    	
      //salvar a imagem temporaria em uma pasta
      String nomeArquivo = "qrcode_"+ System.currentTimeMillis() + ".png";
      Path caminho = Paths.get("src/main/resources/static/images_qrcode", nomeArquivo);	
    	
        final var dadosPix =
                new DadosEnvioPix(
                        qrcode.getNomeBeneficiario(), qrcode.getDescricao(),
                       qrcode.getValor(), qrcode.getCidadeBeneficiario(), "Pagamento Mecânica Leonildo");

        final var qrCodePix = new QRCodePix(dadosPix);
        //qrCodePix.save(Path.of(imagePath));

        qrcode.setImagemQrCode(qrCodePix.saveAndGetBytes(caminho));
        qrcode.setChaveCopiaCola(qrCodePix.toString());
        System.out.println("Copia e Cola: " + qrCodePix);
        
        System.out.println("QRCode:");
        System.out.println(qrCodePix);
        System.out.printf("%nArquivo gerado em " + caminho);
     
        return qrcode;   
   }
}
