package br.oficina.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.oficina.repositories.TipoChavePixRepository;
import br.oficina.service.MecanicoService;
import br.oficina.service.PaginacaoService;
import br.oficina.service.QRCodeService;
import br.oficina.service.TipoChavePixService;
import br.oficina.util.OficinaHelper;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/qrcode")
public class QRCodeController {
	
	@Autowired
	private TipoChavePixService tipoChavePixService;
	
	@Autowired
	private TipoChavePixRepository tipoChavePixRepository;
	
	@Autowired
	private  MecanicoService mecanicoService;
	
	@Autowired
	private QRCodeRepository repository;
	
	@Autowired
	private  QRCodeService qrCodeService;
	
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
		
		mv.addObject("qrcodeDTO",new QRCode());
		
		return mv;
	}
	
	@PostMapping
	public ModelAndView salvar(@Validated QRCode qrcode) {
		System.out.println("entrou no salvar");
		Usuario principal = OficinaHelper.setUsuarioLogado();
		Mecanico mecanico = mecanicoService.findById(principal.getId());
		qrcode.setMecanico(mecanico);
		
		//qrcode.setValor(new BigDecimal(0.1));
		
		QRCode qrcodeSalvar = qrCodeService.gerarQrCode(qrcode);
		qrCodeService.salvar(qrcodeSalvar);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pesquisarQrCode",new QRCode());
		mv.addObject("abrirModal",true);
		mv.addObject("cadastrarQrCode");
		
		return mv;
	}

	//chamado via javascript- cadastrarQRCode, so funciona com RequestBody
	@PostMapping(value="/executar-funcao", consumes = "application/json") 
	@ResponseBody
	public ResponseEntity<?> gerarQrCode(
			@RequestBody QRCodeDTO qrcodeDTO,
			@RequestHeader(name = "Authorization")String token,
			HttpServletRequest request) {
		
		System.out.println("Headers recebidos: " + request.getHeaderNames());
		System.out.println("Authorization recebido: " + token);
		System.out.println("Entrou no metodo gerarQRCode: " + token);
		
		
		TipoChavePix tipoSelecionado = new TipoChavePix();
		
		if(qrcodeDTO.getTipoChavepix() != null) {
			tipoSelecionado = tipoChavePixRepository.findById(Long.parseLong(qrcodeDTO.getTipoChavepix()))
					.orElseThrow(() -> new IllegalArgumentException("Tipo de chave nao encontrado")); 
		}
				
		QRCode qrcodeSalvar = qrCodeService.gerarQrCodeTeste(qrcodeDTO);
		qrcodeSalvar.setTipoChavepix(tipoSelecionado);
		
		byte[]imagemBytes = qrcodeSalvar.getImagemQrCode();
				
		//salvar a imagem temporaria em uma pasta
		String nomeArquivo = "qrcode_"+ System.currentTimeMillis() + ".png";
		Path caminho = Paths.get("src/main/resources/static/images_qrcode", nomeArquivo);
		
		try {
			Files.createDirectories(caminho.getParent()); //cria a pasta se nao existir
			System.out.println("entrou no primeiro try catch;criar o diretorio");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		try {
			Files.write(caminho, imagemBytes);  //salva a imagem na pasta do projeto
			System.out.println("entrou no segundo try catch; salvar imagem");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("hora de retornar");
		return new ResponseEntity<>(qrcodeSalvar, HttpStatus.OK);
	}
	
	@GetMapping("/pesquisarQrCode/pagina/{pageNum}")
	public String findPaginated( 
		@RequestParam("sortField") String sortField,
		@RequestParam("sortDir") String sortDir,
		@PathVariable (value = "pageNum") int pageNum,
		@ModelAttribute("filtro") PesquisaFilter nome,
		Model model) {
					
		model = paginacaoService.findPaginated(
				sortField, sortDir, pageNum, model, repository);
				
		model.addAttribute("listaQrCodes", model.getAttribute("lista"));
		model.addAttribute("url","/qrcode/pesquisarQrCode/pagina/");
				
		return "pesquisarQrCode";
	}
	
}
