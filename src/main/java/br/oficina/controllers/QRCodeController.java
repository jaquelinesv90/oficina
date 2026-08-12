package br.oficina.controllers;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.dto.QRCodeDTO;
import br.oficina.filter.PesquisaFilter;
import br.oficina.models.Mecanico;
import br.oficina.models.QRCode;
import br.oficina.models.TipoChavePix;
import br.oficina.models.Usuario;
import br.oficina.repositories.QRCodeRepository;
import br.oficina.service.MecanicoService;
import br.oficina.service.PaginacaoService;
import br.oficina.service.QRCodeService;
import br.oficina.service.TipoChavePixService;
import br.oficina.util.OficinaHelper;

@Controller
@RequestMapping("/qrcode")
public class QRCodeController {

	@Autowired
	private TipoChavePixService tipoChavePixService;

	@Autowired
	private MecanicoService mecanicoService;

	@Autowired
	private QRCodeRepository repository;

	@Autowired
	private QRCodeService qrCodeService;

	@Autowired
	private PaginacaoService paginacaoService;

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
		mv.addObject("qrcodeSalvar", new QRCode());
		mv.addObject("qrcodeDTO", new QRCodeDTO());
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Validated QRCodeDTO qrcodeDTO) {
		Usuario principal = OficinaHelper.setUsuarioLogado();
		Mecanico mecanico = mecanicoService.findById(principal.getId());

		QRCode qrcodeSalvar = qrCodeService.gerarQrCode(qrcodeDTO);
		qrcodeSalvar.setMecanico(mecanico);
		qrCodeService.salvar(qrcodeSalvar);

		ModelAndView mv = new ModelAndView();
		mv.addObject("pesquisarQrCode", new QRCode());
		mv.addObject("abrirModal", true);
		mv.addObject("cadastrarQrCode");
		return mv;
	}

	@PostMapping(value = "/gerar-qrcode", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Map<String, String>> gerarQrCode(@RequestBody QRCodeDTO qrcodeDTO,
			@RequestHeader(name = "Authorization") String token) {
		QRCode qrcodeSalvar = qrCodeService.gerarQrCode(qrcodeDTO);
		String imagemBase64 = Base64.getEncoder().encodeToString(qrcodeSalvar.getImagemQrCode());

		Map<String, String> resposta = new HashMap<>();
		resposta.put("imagemBase64", imagemBase64);
		resposta.put("chaveCopiaCola", qrcodeSalvar.getChaveCopiaCola());

		return ResponseEntity.ok(resposta);
	}

	@GetMapping("/pesquisarQrCode/pagina/{pageNum}")
	public String findPaginated(@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir,
			@PathVariable(value = "pageNum") int pageNum, @ModelAttribute("filtro") PesquisaFilter nome, Model model) {

		model = paginacaoService.findPaginated(sortField, sortDir, pageNum, model, repository);
		model.addAttribute("listaQrCodes", model.getAttribute("lista"));
		model.addAttribute("url", "/qrcode/pesquisarQrCode/pagina/");
		return "pesquisarQrCode";
	}
}