package hu.wysio.kocsmabackend.repository;

import hu.wysio.datamanager.model.Fogyasztas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface FogyasztasRepo extends JpaRepository<Fogyasztas, Long> {

	@Query("select v.becenev, sum(f.hanyEgysegetFogyasztott*(i.alkoholTartalom/100.0*i.egyAdagMennyisege)) as elfogyasztottAlkoholMennyisege " +
			"from Fogyasztas f " +
			"inner join Ital i on f.ital.id = i.id " +
			"inner join Vendeg v on f.vendeg.id  = v.id " +
			"group by v.becenev " +
			"order by elfogyasztottAlkoholMennyisege desc")
	List<Tuple> getVendegRangsorByElfogyasztottAlkoholMennyiseg();
}
