package hu.wysio.kocsmabackend.dto.bunyo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BunyoTabellaDto implements Serializable {

	private String vendegBecenev;
	private Integer bunyoReszvetelSzama;
	private Integer nyeresekSzama;
	private Integer nyeresiArany;
}
