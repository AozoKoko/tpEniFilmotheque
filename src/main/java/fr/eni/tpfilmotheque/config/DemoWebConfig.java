package fr.eni.tpfilmotheque.config;

import fr.eni.tpfilmotheque.bo.Avis;
import fr.eni.tpfilmotheque.repository.AvisRepository;
import fr.eni.tpfilmotheque.repository.FilmRepository;
import fr.eni.tpfilmotheque.repository.ParticipantRepository;
import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class DemoWebConfig {

    private Participant superRealisateur= new Participant(1L,"Filmeur", "Jean");
    private Film film1 = new Film(1L,"Un film",2020,120,"Un film qui se finit bien",superRealisateur);
    private Film film2 = new Film(2L,"Un film 2 le retour de l'enfant héros",2020,120,"Un film qui se finit mal",superRealisateur);
    private Film film3 = new Film(3L,"Un film révélations",2020,120,"Un film qui se finit pas",superRealisateur);

    private Avis avisSurFilm1 =  new Avis(2, "Il se finit bien mais le reste est nul");

//
//    @Bean
//    @ApplicationScope
//    public List<Participant> realisateurs(RealisateurService service){
//
//        return service.getListeRealisateurs();
//    }

    @Bean
    @ApplicationScope
    public CommandLineRunner demo(FilmRepository filmRepository, ParticipantRepository participantRepository, AvisRepository avisRepository){
      return (args) -> {
          participantRepository.save(superRealisateur);
          filmRepository.save(film1);
          filmRepository.save(film2);
          filmRepository.save(film3);
          avisSurFilm1.setFilm(film1);
          avisRepository.save(avisSurFilm1);

          System.out.printf("List de tous les films");
          filmRepository.findAll().forEach(film -> System.out.println(film));
          participantRepository.findAll().forEach(realisateur -> System.out.println(realisateur));
      };
    }
}
