package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.dto.vendeg.VendegDto;
import hu.wysio.kocsmabackend.repository.VendegRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CreateVendegServiceTest {

	@MockBean
	private VendegRepo vendegRepo;

	@Autowired
	private VendegService vendegService;

	@Test
	void createVendeg() throws KocsmaException {

		VendegDto vendegDto = new VendegDto();
		vendegDto.setBecenev("Jolika");
		vendegDto.setBicepszMeret(10);
		vendegDto.setMajerosseg("tini");

		vendegService.createVendeg(vendegDto);

		verify(vendegRepo).save(Mockito.any());
	}
}
