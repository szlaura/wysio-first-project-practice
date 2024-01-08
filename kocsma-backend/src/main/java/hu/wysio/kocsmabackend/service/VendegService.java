package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.exception.VendegException;
import hu.wysio.datamanager.message.ErrorMessage;
import hu.wysio.datamanager.model.Vendeg;
import hu.wysio.kocsmabackend.converter.VendegConverter;
import hu.wysio.kocsmabackend.dto.vendeg.VendegDto;
import hu.wysio.kocsmabackend.repository.VendegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

@Service
public class VendegService {

	@Autowired
	private Validator validator;

	@Autowired
	private VendegRepo vendegRepo;

	@Autowired
	private VendegConverter vendegConverter;

	public void createVendeg(VendegDto vendegDto) throws KocsmaException {

		try {
			Vendeg vendeg = vendegConverter.toEntity(vendegDto);
			validator.validate(vendeg);
			vendegRepo.save(vendeg);
		} catch (Exception e) {
			throw new VendegException(ErrorMessage.CREATE_FAILED, e);
		}
	}
}


