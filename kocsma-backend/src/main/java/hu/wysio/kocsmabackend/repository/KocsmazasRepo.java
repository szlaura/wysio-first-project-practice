package hu.wysio.kocsmabackend.repository;

import hu.wysio.datamanager.model.Kocsmazas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KocsmazasRepo extends JpaRepository<Kocsmazas, Long> {
}
