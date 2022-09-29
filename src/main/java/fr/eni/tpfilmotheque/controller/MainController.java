package fr.eni.tpfilmotheque.controller;

import fr.eni.tpfilmotheque.bo.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/films")
public class MainController {

    private Film film1 = new Film(1L,"Un film",2020,120,"Un film qui se finit bien");
    private Film film2 = new Film(2L,"Un film 2 le retour de l'enfant héros",2020,120,"Un film qui se finit mal");
    private Film film3 = new Film(3L,"Un film révélations",2020,120,"Un film qui se finit pas");


    private List<Film> array = new ArrayList<Film>();



    @RequestMapping("")
    public String getAllFilms(Model model){
        array.add(film1);
        array.add(film2);
        array.add(film3);

        model.addAttribute("listeFilms",array);

        return "index";
    }

    @RequestMapping("view/{id}")
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

}
