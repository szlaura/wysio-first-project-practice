package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.repository.BunyoRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class BeginBunyoServiceTest {

	@MockBean
	private BunyoRepo bunyoRepo;

	@Autowired
	private BunyoService bunyoService;

	@Test
	void beginBunyo() throws KocsmaException {

		List<Long> vendegIdList = new ArrayList<>();
		vendegIdList.add(2L);
		vendegIdList.add(3L);
		vendegIdList.add(27L);

		bunyoService.beginBunyo(vendegIdList);

		verify(bunyoRepo).save(Mockito.any());
	}
}
