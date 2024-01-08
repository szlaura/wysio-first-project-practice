package hu.wysio.kocsmabackend.repository;

import hu.wysio.datamanager.model.Vendeg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendegRepo extends JpaRepository<Vendeg, Long> {
}
