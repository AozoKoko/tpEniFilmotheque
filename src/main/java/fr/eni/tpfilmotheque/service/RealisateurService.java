package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.bo.Participant;

import java.util.List;
import java.util.Map;

public interface RealisateurService {
    public List<Participant> getListeRealisateurs();

    public Map<Long, Participant> getMapRealisateurs();
}
