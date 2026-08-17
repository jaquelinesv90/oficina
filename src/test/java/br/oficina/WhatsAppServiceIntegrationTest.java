package br.oficina;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WhatsAppServiceIntegrationTest {


	//@Autowired
    //private WhatsAppService whatsAppService;


    @Test
    void deveEnviarMensagemParaMeuWhatsApp() throws InterruptedException {
        String meuNumero = "5541999999999"; // seu número, com DDI+DDD, sem espaços/traços
        String mensagem = "Teste de integração funcionando! ✅";


        //whatsAppService.enviarMensagem(meuNumero, mensagem);


        // Como o envio é assíncrono (WebClient .subscribe()), 
        // damos um tempo pra requisição completar antes do teste terminar
        Thread.sleep(3000);
    }
}
