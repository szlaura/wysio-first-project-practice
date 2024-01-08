package hu.wysio.kocsmabackend.dto.bunyo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBunyoRequestDto implements Serializable {

	@JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private LocalDateTime mettol;
	private List<Long> vendegIdList;

}
