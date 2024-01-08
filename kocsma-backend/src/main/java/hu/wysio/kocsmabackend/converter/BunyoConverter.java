package hu.wysio.kocsmabackend.converter;

import hu.wysio.kocsmabackend.dto.bunyo.BunyoTabellaDto;
import org.springframework.stereotype.Component;

@Component
public class BunyoConverter {

	public BunyoTabellaDto toBunyoTabellaDto(String vendegBecenev, Integer bunyoReszvetelSzama, Integer nyeresekSzama, Integer nyeresiArany) {

		BunyoTabellaDto bunyoTabellaDto = new BunyoTabellaDto();

		bunyoTabellaDto.setVendegBecenev(vendegBecenev);
		bunyoTabellaDto.setBunyoReszvetelSzama(bunyoReszvetelSzama);
		bunyoTabellaDto.setNyeresekSzama(nyeresekSzama);
		bunyoTabellaDto.setNyeresiArany(nyeresiArany);

		return bunyoTabellaDto;
	}
}
