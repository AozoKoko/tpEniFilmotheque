package fr.eni.tpfilmotheque.repository;

import fr.eni.tpfilmotheque.bo.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis, Long> {
}
