package br.oficina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.oficina.dto.QRCodeDTO;
import br.oficina.models.Mecanico;
import br.oficina.models.QRCode;
import br.oficina.models.Usuario;
import br.oficina.service.MecanicoService;
import br.oficina.service.QRCodeService;

public class QRCodeServiceTests {

	private final MecanicoService mecanicoService = Mockito.mock(MecanicoService.class);
	private final QRCodeService service = new QRCodeService();

	@Test
	void deveGerarQrCodeComDadosCorretos() {
		// Arrange
		QRCodeDTO dto = new QRCodeDTO();
		dto.setNomeBeneficiario("Leonildo");
		dto.setCidadeBeneficiario("Curitiba");
		dto.setDescricao("Troca de óleo");
		dto.setValor("100,00");

		Usuario usuario = new Usuario();
		usuario.setId(1L);
		Mecanico mecanico = new Mecanico();
		mecanico.setId(1L);

		Mockito.when(mecanicoService.findById(1L)).thenReturn(mecanico);

		// Act
		QRCode qrCode = service.gerarQrCode(dto);

		// Assert
		assertNotNull(qrCode.getImagemQrCode());
		assertNotNull(qrCode.getChaveCopiaCola());
		assertEquals("Leonildo", qrCode.getNomeBeneficiario());
		assertEquals("Troca de óleo", qrCode.getDescricao());
		assertEquals("100.00", qrCode.getValor()); // valor já formatado
		assertEquals(mecanico, qrCode.getMecanico());
	}
}
