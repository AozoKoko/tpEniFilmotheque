package fr.eni.tpfilmotheque.bo;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "FILMS")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    private Long id;

    @Basic(optional = false)
    @NotBlank
    private  String titre;

    @Basic(optional = false)
    @Min(1850)
    private  int annee;

    @Basic(optional = false)
    @Min(1)
    private  int duree;

    @Basic(optional = false)
    @Size(min = 20, max = 255)
    private  String synopsis;

    @ManyToOne
    @NotNull
    private Participant realisateur;


    public Film() {
    }
    public Film(Long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public Film(Long id, String titre, int annee, int duree, String synopsis, Participant realisateur) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.realisateur = realisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", synopsis='" + synopsis + '\'' +
                ", realisateur='" + realisateur.toString() + '\'' +
                '}';
    }
}
