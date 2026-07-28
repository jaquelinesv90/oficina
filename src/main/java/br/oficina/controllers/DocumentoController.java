package br.oficina.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.enumeradores.TipoDocumento;
import br.oficina.filter.PesquisaPorNomeFilter;
import br.oficina.models.Documento;
import br.oficina.models.Mecanico;
import br.oficina.models.Usuario;
import br.oficina.repositories.DocumentoRepository;
import br.oficina.service.DocumentoService;
import br.oficina.service.MecanicoService;
import br.oficina.service.PaginacaoService;
import br.oficina.util.OficinaHelper;

@Controller
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @Autowired
    private DocumentoRepository repository;

    @Autowired
    private PaginacaoService paginacaoService;

    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("pesquisarDocumento");
        List < Documento > documentos = service.findAll();

        mv.addObject("listaDocumentos", documentos);

        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {

        ModelAndView mv = new ModelAndView("cadastrarDocumento");
        mv.addObject("listaTipos", TipoDocumento.values());
        mv.addObject(new Documento());

        return mv;
    }

    @GetMapping("/pesquisarDocumento")
    public String pesquisarDocumento(@ModelAttribute("filtro") PesquisaPorNomeFilter nome, Model model) {

        return findPaginated("nome", "asc", 1, nome, model);
    }

    @GetMapping("/pesquisarDocumento/pagina/{pageNum}")
    public String findPaginated(
        @RequestParam("sortField") String sortField,
        @RequestParam("sortDir") String sortDir,
        @PathVariable(value = "pageNum") int pageNum,
        @ModelAttribute("filtro") PesquisaPorNomeFilter nome,
        Model model) {

        model = paginacaoService.findPaginated(
            sortField, sortDir, pageNum, model, repository);

        model.addAttribute("listaClientes", model.getAttribute("lista"));
        model.addAttribute("url", "/documento/pesquisarDocumento/pagina/");

        return "pesquisarDocumento";
    }

    // upload de arquivo
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView upload(Documento documento, @RequestParam("pdf") MultipartFile file) throws IOException {

        Usuario principal = OficinaHelper.setUsuarioLogado();
        Mecanico mecanico = mecanicoService.findById(principal.getId());
        documento.setMecanico(mecanico);

        if (!file.getContentType().equals("application/pdf")) {
            // return ResponseEntity
        }

        String uuid = UUID.randomUUID().toString();

        Documento documentoSalvar = new Documento(documento.getTipo(), documento.getNome(), documento.getMecanico(), file.getSize(),
            file.getBytes(), LocalDate.now(), uuid);

        service.salvar(documentoSalvar);

        ModelAndView mv = new ModelAndView("cadastrarDocumento");

        mv.addObject("mensagem", "Documento salvo com sucesso");
        return mv;
    }

    @GetMapping("/download/{documentoId}")
    public ResponseEntity <byte[]> download(@PathVariable Long id) {
        byte[] pdf =  service.findById(Long.valueOf(id)).getConteudo();

        return ResponseEntity.ok()
        		.contentType(MediaType.APPLICATION_PDF)
        		.header("Content-Disposition", "inline;filename=documento.pdf")
        		.body(pdf);
    }

}