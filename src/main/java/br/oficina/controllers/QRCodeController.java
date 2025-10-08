package br.oficina.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.models.Documento;
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
	
	@GetMapping
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("pesquisarQrCode");
		List<QRCode> documentos = qrCodeService.findAll();

		mv.addObject("listaQRCodes", documentos);

		return mv;
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
	public ModelAndView salvar2(@Validated QRCode qrcode) {
		
		Usuario principal = OficinaHelper.setUsuarioLogado();
		Mecanico mecanico = mecanicoService.findById(principal.getId());
		qrcode.setMecanico(mecanico);
		
		qrcode.setValor(new BigDecimal(0.1));
		
		QRCode qrcodeSalvar = qrCodeService.gerarQrCode(qrcode);
		
		qrCodeService.salvar(qrcodeSalvar);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("qrcode",new QRCode());
		mv.addObject("abrirModal",true);
		mv.addObject("cadastrarQrCode");
		
		return mv;
	}

	@GetMapping(value="/executar-funcao") 
	@ResponseBody
	public ResponseEntity<QRCode> salvar(@RequestParam(name="qrcode") QRCode qrcode) {
		
		Usuario principal = OficinaHelper.setUsuarioLogado();
		Mecanico mecanico = mecanicoService.findById(principal.getId());
		qrcode.setMecanico(mecanico);
		
		qrcode.setValor(new BigDecimal(0.1));
		
		QRCode qrcodeSalvar = qrCodeService.gerarQrCode(qrcode);
		
		qrCodeService.salvar(qrcodeSalvar);
		
		return new ResponseEntity<>(qrcodeSalvar, HttpStatus.OK);
	}
	
}
