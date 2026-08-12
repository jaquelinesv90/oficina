package br.oficina.dto;

public class QrCodeResponseDTO {

    private String imagemBase64;
    private String chaveCopiaCola;

    public QrCodeResponseDTO(String imagemBase64, String chaveCopiaCola) {
        this.imagemBase64 = imagemBase64;
        this.chaveCopiaCola = chaveCopiaCola;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public String getChaveCopiaCola() {
        return chaveCopiaCola;
    }

    public void setChaveCopiaCola(String chaveCopiaCola) {
        this.chaveCopiaCola = chaveCopiaCola;
    }
}


