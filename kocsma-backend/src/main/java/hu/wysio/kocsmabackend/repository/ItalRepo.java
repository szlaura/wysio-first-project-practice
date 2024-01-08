package hu.wysio.kocsmabackend.repository;

import hu.wysio.datamanager.model.Ital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItalRepo extends JpaRepository<Ital, Long> {
}
