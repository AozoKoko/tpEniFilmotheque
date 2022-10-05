package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;

import java.util.ArrayList;
import java.util.List;

public class FilmServiceImpl {

    private Participant superRealisateur= new Participant(1L,"Filmeur", "Jean");
    private Film film1 = new Film(1L,"Un film",2020,120,"Un film qui se finit bien",superRealisateur);
    private Film film2 = new Film(2L,"Un film 2 le retour de l'enfant héros",2020,120,"Un film qui se finit mal",superRealisateur);
    private Film film3 = new Film(3L,"Un film révélations",2020,120,"Un film qui se finit pas",superRealisateur);



    public List<Film> listeDesFilms() {
        List<Film> array = new ArrayList<Film>();
        array.add(film1);
        array.add(film2);
        array.add(film3);
        return array;

    }


    public List<Participant> listeDesRealisateurs() {
        List<Participant> realisateurs = new ArrayList<Participant>();
        realisateurs.add(superRealisateur);
        return realisateurs;
    }


}
