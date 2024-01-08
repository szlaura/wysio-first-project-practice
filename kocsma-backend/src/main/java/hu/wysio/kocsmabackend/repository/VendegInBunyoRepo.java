package hu.wysio.kocsmabackend.repository;

import hu.wysio.datamanager.model.VendegInBunyo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendegInBunyoRepo extends JpaRepository<VendegInBunyo, Long> {

	VendegInBunyo findByVendegId(Long id);

}
