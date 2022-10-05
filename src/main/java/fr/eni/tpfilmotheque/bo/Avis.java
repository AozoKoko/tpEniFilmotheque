package fr.eni.tpfilmotheque.bo;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;

@Entity
@Table(name = "AVIS")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private int note;

    @Basic(optional = false)
    private String commentaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_film")
    private Film film;

//    @ManyToOne
//    private Membre membre;

    public Avis(){}
    public Avis( int note, String commentaire) {
        this.note = note;
        this.commentaire = commentaire;
    }

    public Avis( int note, String commentaire, Film film) {
        this.note = note;
        this.commentaire = commentaire;
        this.film = film;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", film=" + film +
                '}';
    }
}
