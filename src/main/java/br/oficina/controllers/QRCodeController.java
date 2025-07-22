package br.oficina.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import br.oficina.models.Mecanico;
import br.oficina.models.QRCode;
import br.oficina.models.TipoChavePix;
import br.oficina.models.Usuario;
import br.oficina.service.MecanicoService;
import br.oficina.service.QRCodeService;
import br.oficina.service.TipoChavePixService;
import br.oficina.util.OficinaHelper;

@Controller
@RequestMapping("/qrcode")
public class QRCodeController {
	
	@Autowired
	private TipoChavePixService tipoChavePixService;
	
	@Autowired
	private  MecanicoService mecanicoService;
	
	@Autowired
	private  QRCodeService qrCodeService;
	
	@GetMapping
	public String pesquisar() {
		return "pesquisarQrCode";
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		
		List<TipoChavePix> todosPagamento = tipoChavePixService.findAll();
		
		ModelAndView mv = new ModelAndView("cadastrarQrCode");
		
		mv.addObject("listaTiposChavePix", todosPagamento);
		
		mv.addObject("qrcode",new QRCode());
		
		return mv;
	}
	
	@PostMapping
	public ModelAndView salvar(@Validated QRCode qrcode) {
		
		Usuario principal = OficinaHelper.setUsuarioLogado();
		Mecanico mecanico = mecanicoService.findById(principal.getId());
		qrcode.setMecanico(mecanico);
		
		qrcode.setValor(new BigDecimal(0.1));
		
		
		qrCodeService.gerarQrCode(qrcode);
		
		//qrCodeService.salvar(qrcode);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	


}
