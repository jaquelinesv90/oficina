package br.oficina.util;

public class FileUtils {

    public static String gerarNomeArquivo(String prefixo, String extensao) {
        return prefixo + System.currentTimeMillis() + extensao;
    }
}



