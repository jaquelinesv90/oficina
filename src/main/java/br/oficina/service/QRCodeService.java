package br.oficina.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.oficina.dto.QRCodeDTO;
import br.oficina.dto.QrCodeResponseDTO;
import br.oficina.mapper.QRCodeMapper;
import br.oficina.models.Mecanico;
import br.oficina.models.QRCode;
import br.oficina.models.TipoChavePix;
import br.oficina.models.Usuario;
import br.oficina.qrcode.DadosEnvioPix;
import br.oficina.qrcode.infrastructure.QRCodeGenerator;
import br.oficina.repositories.QRCodeRepository;
import br.oficina.repositories.TipoChavePixRepository;
import br.oficina.util.FileUtils;
import br.oficina.util.GenericUtils;
import br.oficina.util.OficinaHelper;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeRepository repository;

    @Autowired
    private TipoChavePixRepository tipoChavePixRepository;

    @Autowired
    private final QRCodeGenerator qrCodeGenerator;
    
    @Autowired
    private final MecanicoService mecanicoService;

    public QRCodeService(MecanicoService mecanicoService, QRCodeGenerator qrCodeGenerator) {
        this.mecanicoService = mecanicoService;
        this.qrCodeGenerator = qrCodeGenerator;
    }

    public List<QRCode> findAll() {
        return repository.findAll();
    }

    public void salvar(QRCode qrcode) {
        repository.save(qrcode);
    }

    @PostMapping(value="/gerar-qrcode", consumes = "application/json")
    @ResponseBody
    public QRCode gerarQrCode(QRCodeDTO dto) {
        dto.setValor(GenericUtils.removeFormatacaoMonetaria(dto.getValor()).toString());
        QRCode qrcode = QRCodeMapper.INSTANCE.toEntity(dto);

        String nomeArquivo = FileUtils.gerarNomeArquivo("qrcode_", ".png");

        DadosEnvioPix dadosPix = new DadosEnvioPix(
                qrcode.getNomeBeneficiario(),
                qrcode.getDescricao(),
                qrcode.getValor(),
                qrcode.getCidadeBeneficiario(),
                "Pagamento Mecanica Leonildo"
        );

        // Agora o generator retorna os bytes
        byte[] imagemBytes = qrCodeGenerator.gerar(dadosPix, nomeArquivo, qrcode);
        qrcode.setImagemQrCode(imagemBytes);

        Usuario principal = OficinaHelper.setUsuarioLogado();
        Mecanico mecanico = mecanicoService.findById(principal.getId());
        qrcode.setMecanico(mecanico);

        return qrcode;
    }

    public QrCodeResponseDTO processarGeracaoQrCode(QRCodeDTO dto) {
        TipoChavePix tipoSelecionado = buscarTipoChavePix(dto.getTipoChavepix());
        QRCode qrcode = gerarQrCode(dto);
        qrcode.setTipoChavepix(tipoSelecionado);

        String imagemBase64 = Base64.getEncoder().encodeToString(qrcode.getImagemQrCode());
        return new QrCodeResponseDTO(imagemBase64, qrcode.getChaveCopiaCola());
    }

    private TipoChavePix buscarTipoChavePix(String tipoChavePixId) {
        if (tipoChavePixId == null) return null;
        return tipoChavePixRepository.findById(Long.parseLong(tipoChavePixId))
                .orElseThrow(() -> new IllegalArgumentException("Tipo de chave não encontrado"));
    }
}