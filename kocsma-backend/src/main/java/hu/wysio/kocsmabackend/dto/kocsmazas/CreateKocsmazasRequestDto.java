package hu.wysio.kocsmabackend.dto.kocsmazas;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateKocsmazasRequestDto implements Serializable {

	@JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private Date mettol;

}