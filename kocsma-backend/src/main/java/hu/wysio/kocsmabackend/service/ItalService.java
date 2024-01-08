package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.ItalException;
import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.message.ErrorMessage;
import hu.wysio.datamanager.model.Ital;
import hu.wysio.kocsmabackend.converter.ItalConverter;
import hu.wysio.kocsmabackend.dto.ital.ItalDto;
import hu.wysio.kocsmabackend.repository.ItalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItalService {

	@Autowired
	private ItalRepo italRepo;

	@Autowired
	private ItalConverter italConverter;

	public void createItal(ItalDto italDto) throws KocsmaException {

		try {
			Ital ital = italConverter.toEntity(italDto);
			italRepo.save(ital);
		} catch (Exception e) {
			throw new ItalException(ErrorMessage.CREATE_FAILED, e);
		}
	}
}
