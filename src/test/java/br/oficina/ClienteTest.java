package br.oficina;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.oficina.controller.ClienteController;
import br.oficina.model.Carro;
import br.oficina.model.Cliente;
import br.oficina.model.Marca;

public class ClienteTest {
	
	@Test
	public void testSalvarNovoCliente() {
		List<Carro> carros = new ArrayList<>();
		Carro r= new Carro();
		Marca m = new Marca();
		m.setNome("Volkswagen");
		
		r.setAno(2005);
		r.setCor("Branco");
		r.setMarca(m);
		r.setPlaca("AAA-2345");
		
		carros.add(r);
		Cliente c = new Cliente();
		
		c.setNome("Teste de insercao");
		c.setCelular(new BigDecimal(99999999));
		c.setMecanico("Leonildo");
		c.setCarros(carros);
		
		ClienteController controller = new ClienteController();
		controller.salvar(c);
	}

}
