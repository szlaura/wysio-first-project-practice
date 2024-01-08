package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.exception.KocsmazasException;
import hu.wysio.datamanager.message.ErrorMessage;
import hu.wysio.datamanager.model.Kocsmazas;
import hu.wysio.kocsmabackend.converter.KocsmazasConverter;
import hu.wysio.kocsmabackend.dto.kocsmazas.CreateKocsmazasRequestDto;
import hu.wysio.kocsmabackend.dto.kocsmazas.FinishKocsmazasRequestDto;
import hu.wysio.kocsmabackend.repository.KocsmazasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class KocsmazasService {

	@Autowired
	private KocsmazasRepo kocsmazasRepo;

	@Autowired
	private KocsmazasConverter kocsmazasConverter;

	public void beginKocsmazas(CreateKocsmazasRequestDto kocsmazasDto) throws KocsmaException {
		try {
			Kocsmazas kocsmazas = kocsmazasConverter.toEntity(kocsmazasDto);
			kocsmazasRepo.save(kocsmazas);

		} catch (Exception e) {
			throw new KocsmazasException(ErrorMessage.CREATE_FAILED, e);
		}
	}

	public void finishKocsmazas(Long id, FinishKocsmazasRequestDto kocsmazasDto) throws KocsmaException {
		try {
			Optional<Kocsmazas> kocsmazas = kocsmazasRepo.findById(id);

			if (kocsmazas.isPresent()) {
				Kocsmazas befejezendoKocsmazas = kocsmazas.get();

				befejezendoKocsmazas.setDetoxbaKerules(kocsmazasDto.getDetoxbaKerules());
				befejezendoKocsmazas.setMeddig(kocsmazasDto.getMeddig());

				kocsmazasRepo.save(befejezendoKocsmazas);
			} else {
				throw new KocsmazasException(ErrorMessage.NO_DATA, new EntityNotFoundException());
			}
		} catch (KocsmazasException e) {
			throw new KocsmazasException(ErrorMessage.NO_DATA, e);

		} catch (Exception e) {
			throw new KocsmazasException(ErrorMessage.UPDATE_FAILED, e);

		}
	}
}