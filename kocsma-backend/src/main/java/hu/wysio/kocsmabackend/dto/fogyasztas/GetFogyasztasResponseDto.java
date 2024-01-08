package hu.wysio.kocsmabackend.dto.fogyasztas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetFogyasztasResponseDto implements Serializable {

	private Long vendegId;
	private String vendegNev;
	private String italNev;
	private Integer italEgyadagMennyiseg;
	private Integer fogyasztottMennyiseg;

}
