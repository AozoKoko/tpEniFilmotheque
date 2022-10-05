package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.repository.FilmRepository;
import fr.eni.tpfilmotheque.repository.ParticipantRepository;
import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImplData implements FilmService{

    private FilmRepository filmRepository ;
    private ParticipantRepository participantRepository;

    public FilmServiceImplData(FilmRepository filmRepository, ParticipantRepository participantRepository ){
        this.filmRepository =  filmRepository;
        this.participantRepository = participantRepository;
    }




    @Override
    @Transactional(readOnly = true)
    public List<Film> listeDesFilms() {
        System.out.println("FILM 0");
        System.out.println(filmRepository);
        List<Film> listeF = filmRepository.findAll();
        return listeF;
    }

    @Override
    @Transactional(readOnly = true)
    public Film getFilmById(Long id) {

        return filmRepository.getReferenceById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void createFilm(Film  film) {
        filmRepository.save(film);
    }

    @Override
    public List<Participant> listeDesRealisateurs() {
        return participantRepository.findAll();
    }
}
