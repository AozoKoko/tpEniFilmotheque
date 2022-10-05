package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.bo.Avis;


import java.util.List;

public interface AvisService {
    public List<Avis> listeDesAvis();

    public void createAvis(Avis avis);
}
