package hu.wysio.kocsmabackend.dto.ital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItalDto implements Serializable {

	@NotNull
	@NotEmpty
	private String nev;

	@NotNull
	@PositiveOrZero
	private Double alkoholTartalom;

	@NotNull
	@Positive
	private Integer egyAdagMennyisege;

}
