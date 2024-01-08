package hu.wysio.kocsmabackend.converter;

import hu.wysio.kocsmabackend.dto.fogyasztas.VendegElfogyasztottAlkoholMennyisegDto;
import org.springframework.stereotype.Component;

@Component
public class FogyasztasConverter {

	public VendegElfogyasztottAlkoholMennyisegDto toVendegElfogyasztottAlkoholMennyisegDto(String nev, Double fogyasztas) {

		VendegElfogyasztottAlkoholMennyisegDto vendegElfogyasztottAlkoholMennyisegDto = new VendegElfogyasztottAlkoholMennyisegDto();

		vendegElfogyasztottAlkoholMennyisegDto.setVendegNev(nev);
		vendegElfogyasztottAlkoholMennyisegDto.setFogyasztas(fogyasztas);

		return vendegElfogyasztottAlkoholMennyisegDto;
	}
}
