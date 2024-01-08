package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.kocsmabackend.repository.FogyasztasRepo;
import org.hibernate.jpa.spi.NativeQueryTupleTransformer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class GetVendegByFogyasztottMennyisegTest {

	@MockBean
	private FogyasztasRepo fogyasztasRepo;

	@Autowired
	private FogyasztasService fogyasztasService;

	@Test
	void getVendegRangsorByElfogyasztottAlkoholMennyiseg() throws KocsmaException {

		List<Tuple> tupleList = new ArrayList<>();
		NativeQueryTupleTransformer nativeQueryTupleTransformer = new NativeQueryTupleTransformer();
		tupleList.add((Tuple) nativeQueryTupleTransformer.transformTuple(
				new Object[]{"Marika", 4.5},
				new String[]{"0", "1"}));

		when(fogyasztasRepo.getVendegRangsorByElfogyasztottAlkoholMennyiseg()).thenReturn(tupleList);

		fogyasztasService.getVendegRangsorByElfogyasztottAlkoholMennyiseg();

		verify(fogyasztasRepo).getVendegRangsorByElfogyasztottAlkoholMennyiseg();
	}
}
