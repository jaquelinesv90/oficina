package br.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.oficina.models.QRCode;
import br.oficina.repositories.QRCodeRepository;

@Service
public class QRCodeService {
	
	@Autowired
	private QRCodeRepository repository;

	public List<QRCode>  findAll(){
		return repository.findAll();
	}

}
