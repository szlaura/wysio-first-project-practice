package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.FogyasztasException;
import hu.wysio.datamanager.exception.ItalException;
import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.exception.VendegException;
import hu.wysio.datamanager.message.ErrorMessage;
import hu.wysio.datamanager.model.Fogyasztas;
import hu.wysio.datamanager.model.Ital;
import hu.wysio.datamanager.model.Vendeg;
import hu.wysio.kocsmabackend.converter.FogyasztasConverter;
import hu.wysio.kocsmabackend.dto.fogyasztas.CreateFogyasztasRequestDto;
import hu.wysio.kocsmabackend.dto.fogyasztas.VendegElfogyasztottAlkoholMennyisegDto;
import hu.wysio.kocsmabackend.repository.FogyasztasRepo;
import hu.wysio.kocsmabackend.repository.ItalRepo;
import hu.wysio.kocsmabackend.repository.VendegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Tuple;
import javax.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FogyasztasService {

	@Autowired
	private Validator validator;

	@Autowired
	private FogyasztasRepo fogyasztasRepo;

	@Autowired
	private ItalRepo italRepo;

	@Autowired
	private VendegRepo vendegRepo;

	@Autowired
	private FogyasztasConverter fogyasztasConverter;

	public void createFogyasztas(CreateFogyasztasRequestDto fogyasztasDto) throws KocsmaException {

		Ital ital;
		try {
			ital = italRepo.getById(fogyasztasDto.getFogyasztottItalId());
		} catch (EntityNotFoundException ex) {
			throw new ItalException(ErrorMessage.CREATE_FAILED, ex);
		}

		Vendeg vendeg;
		try {
			vendeg = vendegRepo.getById(fogyasztasDto.getFogyasztoVendegId());
		} catch (EntityNotFoundException ex) {
			throw new VendegException(ErrorMessage.CREATE_FAILED, ex);
		}

		try {
			Fogyasztas ujFogyasztas = new Fogyasztas();
			ujFogyasztas.setItal(ital);
			ujFogyasztas.setVendeg(vendeg);
			ujFogyasztas.setHanyEgysegetFogyasztott(fogyasztasDto.getHanyEgysegetFogyasztott());

			validator.validate(ujFogyasztas);

			fogyasztasRepo.save(ujFogyasztas);
		} catch (Exception e) {
			throw new FogyasztasException(ErrorMessage.CREATE_FAILED, e);
		}
	}

	public List<VendegElfogyasztottAlkoholMennyisegDto> getVendegRangsorByElfogyasztottAlkoholMennyiseg() throws KocsmaException {
		try {
			List<Tuple> vendegTupleListByElfogyasztottAlkoholMennyiseg = fogyasztasRepo.getVendegRangsorByElfogyasztottAlkoholMennyiseg();

			return vendegTupleListByElfogyasztottAlkoholMennyiseg.stream()
					.map(tuple -> {
						String vendegNev = tuple.get(0, String.class);
						Double fogyasztas = tuple.get(1, Double.class);
						return fogyasztasConverter.toVendegElfogyasztottAlkoholMennyisegDto(vendegNev, fogyasztas);
					})
					.collect(Collectors.toList());

		} catch (Exception e) {
			throw new FogyasztasException(ErrorMessage.GET_DATA_FAILED, e);
		}
	}
}
