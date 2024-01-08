package hu.wysio.kocsmabackend.dto.fogyasztas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VendegElfogyasztottAlkoholMennyisegDto implements Serializable {

	private String vendegNev;
	private Double fogyasztas;
}
