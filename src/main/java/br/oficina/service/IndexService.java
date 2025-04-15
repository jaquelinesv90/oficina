package br.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
	
	@Autowired
	private EmailService emailService;
	
	
	public void enviarEmail() {
		emailService.enviarEmailTexto("jaquelinesv90@gmail.com", "teste", "email enviado");
	}

}
