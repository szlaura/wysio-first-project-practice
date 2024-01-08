package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.ItalException;
import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.exception.VendegException;
import hu.wysio.kocsmabackend.dto.fogyasztas.CreateFogyasztasRequestDto;
import hu.wysio.kocsmabackend.repository.FogyasztasRepo;
import hu.wysio.kocsmabackend.repository.ItalRepo;
import hu.wysio.kocsmabackend.repository.VendegRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
@ActiveProfiles("test")
class CreateFogyasztasServiceTest {

	@MockBean
	private ItalRepo italRepo;

	@MockBean
	private VendegRepo vendegRepo;

	@MockBean
	private FogyasztasRepo fogyasztasRepo;

	@Autowired
	private FogyasztasService fogyasztasService;

	@Test
	void createFogyasztas_with_wrong_ital() {

		when(italRepo.getById(2L)).thenThrow(new EntityNotFoundException());

		CreateFogyasztasRequestDto fogyasztasRequestDto = new CreateFogyasztasRequestDto();
		fogyasztasRequestDto.setFogyasztottItalId(2L);
		fogyasztasRequestDto.setFogyasztoVendegId(2L);
		fogyasztasRequestDto.setHanyEgysegetFogyasztott(3);

		Assertions.assertThrows(ItalException.class, () -> fogyasztasService.createFogyasztas(fogyasztasRequestDto));
	}

	@Test
	void createFogyasztas_with_wrong_vendeg() {

		when(vendegRepo.getById(2L)).thenThrow(new EntityNotFoundException());

		CreateFogyasztasRequestDto fogyasztasRequestDto = new CreateFogyasztasRequestDto();
		fogyasztasRequestDto.setFogyasztottItalId(2L);
		fogyasztasRequestDto.setFogyasztoVendegId(2L);
		fogyasztasRequestDto.setHanyEgysegetFogyasztott(3);

		Assertions.assertThrows(VendegException.class, () -> fogyasztasService.createFogyasztas(fogyasztasRequestDto));
	}

	@Test
	void createFogyasztas_with_right_vendeg() throws KocsmaException {

		CreateFogyasztasRequestDto fogyasztasRequestDto = new CreateFogyasztasRequestDto();
		fogyasztasRequestDto.setFogyasztoVendegId(2L);
		fogyasztasRequestDto.setFogyasztoVendegId(2L);
		fogyasztasRequestDto.setHanyEgysegetFogyasztott(2);

		fogyasztasService.createFogyasztas(fogyasztasRequestDto);

		verify(fogyasztasRepo).save(Mockito.any());
	}
}
