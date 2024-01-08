package hu.wysio.kocsmabackend.converter;

import hu.wysio.datamanager.model.Ital;
import hu.wysio.kocsmabackend.dto.ital.ItalDto;
import org.springframework.stereotype.Component;

@Component
public class ItalConverter {

	public Ital toEntity(ItalDto italDto) {

		Ital ital = new Ital();

		ital.setNev(italDto.getNev());
		ital.setAlkoholTartalom(italDto.getAlkoholTartalom());
		ital.setEgyAdagMennyisege(italDto.getEgyAdagMennyisege());

		return ital;
	}
}
