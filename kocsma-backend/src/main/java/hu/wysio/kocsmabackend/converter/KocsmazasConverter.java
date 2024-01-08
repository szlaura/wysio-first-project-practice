package hu.wysio.kocsmabackend.converter;

import hu.wysio.datamanager.model.Kocsmazas;
import hu.wysio.kocsmabackend.dto.kocsmazas.CreateKocsmazasRequestDto;
import org.springframework.stereotype.Component;

@Component
public class KocsmazasConverter {

	public Kocsmazas toEntity(CreateKocsmazasRequestDto kocsmazasDto) {

		Kocsmazas kocsmazas = new Kocsmazas();

		kocsmazas.setMettol(kocsmazasDto.getMettol());

		return kocsmazas;
	}

}
