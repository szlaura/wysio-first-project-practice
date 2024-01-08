package hu.wysio.kocsmabackend.repository;

import hu.wysio.datamanager.model.Bunyo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface BunyoRepo extends JpaRepository<Bunyo, Long> {

	@Query("select v.becenev, count(distinct vib.id), count(distinct b.id), count(distinct b.id) * 100/count(distinct vib.id) from Bunyo b " +
			"inner join Vendeg v on b.nyertes.id = v.id inner join VendegInBunyo vib on b.nyertes.id = vib.vendeg.id " +
			"group by v.becenev " +
			"order by count(distinct b.id) * 100/count(distinct vib.id) desc")
	List<Tuple> getBunyoTabella();
}
