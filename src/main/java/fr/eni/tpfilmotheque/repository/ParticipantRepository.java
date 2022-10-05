package fr.eni.tpfilmotheque.repository;

import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
