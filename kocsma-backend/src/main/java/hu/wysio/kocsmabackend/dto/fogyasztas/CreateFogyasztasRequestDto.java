package hu.wysio.kocsmabackend.dto.fogyasztas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateFogyasztasRequestDto implements Serializable {

	@NotNull
	@Positive
	private Long fogyasztottItalId;

	@NotNull
	@Positive
	private Long fogyasztoVendegId;

	@NotNull
	@Positive
	private Integer hanyEgysegetFogyasztott;

}
