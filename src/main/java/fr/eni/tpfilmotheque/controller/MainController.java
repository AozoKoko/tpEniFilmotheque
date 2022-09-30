package fr.eni.tpfilmotheque.controller;

import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/films")
public class MainController {

    //service initiation valeurs

    private Participant superRealisateur= new Participant(1L,"Filmeur", "Jean");
    private Film film1 = new Film(1L,"Un film",2020,120,"Un film qui se finit bien",superRealisateur);
    private Film film2 = new Film(2L,"Un film 2 le retour de l'enfant héros",2020,120,"Un film qui se finit mal",superRealisateur);
    private Film film3 = new Film(3L,"Un film révélations",2020,120,"Un film qui se finit pas",superRealisateur);


    private List<Film> array = new ArrayList<Film>();
    private List<Participant> realisateurs = new ArrayList<Participant>();

    public MainController(){
        array.add(film1);
        array.add(film2);
        array.add(film3);
    }


    @GetMapping("")
    public String getAllFilms(Model model){


        model.addAttribute("film" , new Film(0L,"titre",2000,120,"synopsis",superRealisateur));
        model.addAttribute("listeFilms",array);

        realisateurs.add(superRealisateur);
        model.addAttribute("listeReal",realisateurs);

        return "index";
    }

    @RequestMapping("view")
    public String getSpecificFilm(@RequestParam int id,
                                  Model modele){

        for (int i = 0; i < array.size(); i++){
            if(id == array.get(i).getId()){
                Film newFilm = array.get(i);

                modele.addAttribute("film",newFilm);
            }
        }

        return "film";
    }

    @PostMapping("/add")
    public String newFilm(@Valid @ModelAttribute("film") Film film, BindingResult erreur){
        if (!erreur.hasErrors()){
            array.add(film);
        }else {
            return "index";
        }


        return "redirect:/films";
    }

}
