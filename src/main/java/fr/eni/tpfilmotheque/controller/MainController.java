package fr.eni.tpfilmotheque.controller;

import fr.eni.tpfilmotheque.bo.Avis;
import fr.eni.tpfilmotheque.repository.FilmRepository;
import fr.eni.tpfilmotheque.repository.ParticipantRepository;
import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;
import fr.eni.tpfilmotheque.service.AvisService;
import fr.eni.tpfilmotheque.service.FilmService;
import fr.eni.tpfilmotheque.service.FilmServiceImplData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"","/films"})
public class MainController {




    private FilmService filmService ;
    private AvisService avisService ;


    private List<Film> array = new ArrayList<Film>();
    private List<Participant> realisateurs = new ArrayList<Participant>();
    private List<Avis> avisList = new ArrayList<Avis>();

    private Avis avis;


    //Nécessité d'utiliser l'injection par constructeur pour instancier le bon service
    public MainController(FilmService filmService, AvisService avisService){

        this.filmService = filmService;
        this.avisService = avisService;
    }




    @GetMapping("")
    public String getAllFilms(Model model){


        array = filmService.listeDesFilms();
        model.addAttribute("film" , new Film(0L,"titre",2000,120,"synopsis",new Participant(1L,"Nom Real","PrenomReal")));
        model.addAttribute("listeFilms",array);


        realisateurs = filmService.listeDesRealisateurs();
        model.addAttribute("realisateurs",realisateurs);

        return "index";
    }

    @RequestMapping("view")
    public String getSpecificFilm(@RequestParam int id,
                                  Model modele){

        Film newFilm =new Film();
        for (int i = 0; i < array.size(); i++){
            if(id == array.get(i).getId()){
                newFilm = array.get(i);

                modele.addAttribute("film",newFilm);
                modele.addAttribute("avis", new Avis(0,"RAS"));
            }
        }
        System.out.println(newFilm.getTitre());

        List<Avis> lesAvisDuFilm = new ArrayList<>();
        avisList = avisService.listeDesAvis();
        for (int i = 0; i < avisList.size(); i++) {
            System.out.println(newFilm.getTitre());
            if (newFilm.getId() == avisList.get(i).getFilm().getId()) {
                lesAvisDuFilm.add(avisList.get(i));
                System.out.println(avisList.get(i).getCommentaire());
            }

        }
        modele.addAttribute("lesAvis",lesAvisDuFilm);

        return "film";
    }

    @PostMapping("/add")
    public String newFilm(@Valid @ModelAttribute("film") Film film, BindingResult erreur){
        if (!erreur.hasErrors()){
          filmService.createFilm(film);
        }else {
            return "index";
        }


        return "redirect:/films";
    }

    @PostMapping("/avis/add")
    public String newAvis(@Valid @ModelAttribute("avis") Avis avis, BindingResult erreur, @RequestParam("id") Long id, Model model){


        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        avis.setFilm(film);
        avis.setId(null);

        System.out.println(avis);
        avisService.createAvis(avis);


        return "redirect:/films";
    }

}
