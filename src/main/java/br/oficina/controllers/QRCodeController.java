package br.oficina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.models.Mecanico;
import br.oficina.models.QRCode;
import br.oficina.models.TipoChavePix;
import br.oficina.models.Usuario;
import br.oficina.service.MecanicoService;
import br.oficina.service.TipoChavePixService;
import br.oficina.util.OficinaHelper;

@Controller
@RequestMapping("/pagamento")
public class QRCodeController {
	
	@Autowired
	private TipoChavePixService tipoChavePixService;
	
	@Autowired
	private MecanicoService mecanicoService;
	
	@GetMapping
	public String pesquisar() {
		return "pesquisarPagamentos";
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		
		List<TipoChavePix> todosPagamento = tipoChavePixService.findAll();
		
		ModelAndView mv = new ModelAndView("cadastrarQrCode");
		
		mv.addObject("listaTiposChavePix", todosPagamento);
		
		mv.addObject(new QRCode());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated QRCode qrcode) {
		
		Usuario principal = OficinaHelper.setUsuarioLogado();
		Mecanico mecanico = mecanicoService.findById(principal.getId());
		qrcode.setMecanico(mecanico);
		
		gerar(qrcode);
		//gerar imagem QR Code
		//clienteService.salvar(cliente);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	
	public void gerar(QRCode qrcode){
		
		
		
	}

}
