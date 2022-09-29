package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.bo.Participant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RealisateurServiceImpl implements RealisateurService{

    private List<Participant> listeRealisateurs;
    private Map<Long, Participant> mapRealisateurs;

    public RealisateurServiceImpl() {
        listeRealisateurs = new ArrayList<Participant>();
        listeRealisateurs.add(new Participant(1L,"Filmeur", "Jean"));

        mapRealisateurs = new HashMap<Long, Participant>();
        listeRealisateurs.forEach(m -> mapRealisateurs.put(m.getId(), m));
    }

    @Override
    public List<Participant> getListeRealisateurs() {
        return listeRealisateurs;
    }

    @Override
    public Map<Long, Participant> getMapRealisateurs() {
        return mapRealisateurs;
    }
}
