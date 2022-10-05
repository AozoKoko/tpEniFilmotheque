package fr.eni.tpfilmotheque.repository;

import fr.eni.tpfilmotheque.bo.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
