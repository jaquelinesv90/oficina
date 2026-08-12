package br.oficina.qrcode.infrastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

import br.oficina.models.QRCode;
import br.oficina.qrcode.DadosEnvioPix;
import br.oficina.qrcode.QRCodePix;

@Component
public class QRCodeGenerator {

    /**
     * Gera o QR Code, salva em arquivo e retorna os bytes da imagem.
     */
    public byte[] gerar(DadosEnvioPix dadosPix, String nomeArquivo, QRCode qrcode) {
        try {
            // Instancia o gerador Pix
            QRCodePix qrCodePix = new QRCodePix(dadosPix);

            // Caminho onde salvar a imagem
            Path caminho = Path.of("src/main/resources/static/images_qrcode", nomeArquivo);

            // Salva a imagem no disco
            qrCodePix.save(caminho);

            // Lê os bytes do arquivo salvo
            byte[] imagemBytes = Files.readAllBytes(caminho);

            // Atualiza entidade
            qrcode.setImagemQrCode(imagemBytes);
            qrcode.setChaveCopiaCola(qrCodePix.toString());
            qrcode.setNomeArquivo(nomeArquivo);

            return imagemBytes;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar QR Code", e);
        }
    }
}