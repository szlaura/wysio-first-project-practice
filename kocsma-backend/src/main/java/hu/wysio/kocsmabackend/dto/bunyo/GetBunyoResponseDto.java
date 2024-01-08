package hu.wysio.kocsmabackend.dto.bunyo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetBunyoResponseDto implements Serializable {

	private Long bunyoId;
	private List<Long> vendegIdList;

}
