package hu.wysio.kocsmabackend.service;

import hu.wysio.datamanager.exception.BunyoException;
import hu.wysio.datamanager.exception.KocsmaException;
import hu.wysio.datamanager.message.ErrorMessage;
import hu.wysio.datamanager.model.Bunyo;
import hu.wysio.datamanager.model.VendegInBunyo;
import hu.wysio.kocsmabackend.converter.BunyoConverter;
import hu.wysio.kocsmabackend.dto.bunyo.BunyoTabellaDto;
import hu.wysio.kocsmabackend.repository.BunyoRepo;
import hu.wysio.kocsmabackend.repository.VendegInBunyoRepo;
import hu.wysio.kocsmabackend.repository.VendegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BunyoService {

	@Autowired
	private BunyoRepo bunyoRepo;

	@Autowired
	private VendegRepo vendegRepo;

	@Autowired
	private VendegInBunyoRepo vendegInBunyoRepo;

	@Autowired
	private BunyoConverter bunyoConverter;

	public void beginBunyo(List<Long> vendegIdList) throws KocsmaException {

		try {
			Bunyo bunyo = new Bunyo();

			List<VendegInBunyo> vendegInBunyoList = vendegIdList.stream()
					.map(vendegRepo::getById)
					.map(VendegInBunyo::new)
					.collect(Collectors.toList());

			bunyo.setVendegInBunyoList(vendegInBunyoList);
			bunyo.setMettol(LocalDateTime.now());

			bunyoRepo.save(bunyo);
		} catch (Exception e) {
			throw new BunyoException(ErrorMessage.CREATE_FAILED, e);
		}
	}

	public List<BunyoTabellaDto> getBunyoTabella() throws KocsmaException {
		try {
			List<Tuple> bunyoTabellaTupleList = bunyoRepo.getBunyoTabella();

			return bunyoTabellaTupleList.stream()
					.map(t -> {
						String vendegBecenev = t.get(0, String.class);
						Integer bunyoReszvetelSzama = t.get(1, Long.class).intValue();
						Integer nyeresekSzama = t.get(2, Long.class).intValue();
						Integer nyeresiArany = t.get(3, Long.class).intValue();
						return bunyoConverter.toBunyoTabellaDto(vendegBecenev, bunyoReszvetelSzama, nyeresekSzama, nyeresiArany);
					})
					.collect(Collectors.toList());

		} catch (Exception e) {
			throw new BunyoException(ErrorMessage.REQUEST_FAILED, e);
		}
	}

	public void vendegKiesett(Long vendegId) throws KocsmaException {
		try {
			VendegInBunyo vendegInBunyo = vendegInBunyoRepo.findByVendegId(vendegId);

			vendegInBunyo.setKiesett(true);

			vendegInBunyoRepo.save(vendegInBunyo);

		} catch (Exception e) {
			throw new BunyoException(ErrorMessage.UPDATE_FAILED, e);
		}
	}
}
