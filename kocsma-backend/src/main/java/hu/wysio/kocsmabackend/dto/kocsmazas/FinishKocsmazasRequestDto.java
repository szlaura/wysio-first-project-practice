package hu.wysio.kocsmabackend.dto.kocsmazas;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FinishKocsmazasRequestDto implements Serializable {

	@NotNull
	private Boolean detoxbaKerules;

	@JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date meddig;

}
