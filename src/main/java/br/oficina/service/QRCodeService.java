package br.oficina.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import br.oficina.models.QRCode;
import br.oficina.repositories.QRCodeRepository;

@Service
public class QRCodeService {
	
	@Autowired
	private QRCodeRepository repository;
	
	@Autowired
	private QRCodeGeneratorService service;

	public List<QRCode>  findAll(){
		return repository.findAll();
	}
	
	public void salvar(QRCode qrcode) {
		repository.save(qrcode);
	}
	
    // Driver code
    public void gerarQrCode(QRCode qrcode) {
       try {
		service.gerarQrCode(qrcode);
	   } catch (NotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } catch (WriterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
    }
    

}
