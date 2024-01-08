package hu.wysio.kocsmabackend.dto.vendeg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VendegDto implements Serializable {

	@NotNull
	@NotEmpty
	private String becenev;

	@NotNull
	private Integer bicepszMeret;

	@NotNull
	@Size(min = 4)
	private String majerosseg;

}
