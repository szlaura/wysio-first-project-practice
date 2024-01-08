package hu.wysio.kocsmabackend.converter;

import hu.wysio.datamanager.model.Vendeg;
import hu.wysio.kocsmabackend.dto.vendeg.VendegDto;
import org.springframework.stereotype.Component;

@Component
public class VendegConverter {

	public Vendeg toEntity(VendegDto vendegDto) {

		Vendeg vendeg = new Vendeg();

		vendeg.setBecenev(vendegDto.getBecenev());
		vendeg.setBicepszMeret(vendegDto.getBicepszMeret());
		vendeg.setMajerosseg(vendegDto.getMajerosseg());

		return vendeg;
	}
}
