package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;

import java.util.List;

public interface FilmService {
    public List<Film> listeDesFilms();
    public List<Participant> listeDesRealisateurs();
}
