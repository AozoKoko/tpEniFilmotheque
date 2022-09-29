package fr.eni.tpfilmotheque.controller;

import fr.eni.tpfilmotheque.bo.Participant;
import fr.eni.tpfilmotheque.service.RealisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToParticipantConverter implements Converter<String, Participant>{

    private RealisateurServiceImpl service;

    @Autowired
    public void setRealisateurService(RealisateurServiceImpl service) {
        this.service = service;
    }

    @Override
    public Participant convert(String id) {
        Long theid = Long.parseLong(id);

        return service.getMapRealisateurs().get(theid);
    }
}


