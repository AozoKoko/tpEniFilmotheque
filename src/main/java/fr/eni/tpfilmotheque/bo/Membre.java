package fr.eni.tpfilmotheque.bo;


import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "MEMBRES")
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    private long id;

    @Basic(optional = false)
    private String nom;

    @Basic(optional = false)
    private String prenom;

    @Basic(optional = false)
    private String login;

    @Basic(optional = false)
    private String motDePasse;

    @Basic(optional = false)
    private boolean isAdmin;
}
