package fr.eni.tpfilmotheque.service;

import fr.eni.tpfilmotheque.bo.Avis;
import fr.eni.tpfilmotheque.repository.AvisRepository;
import fr.eni.tpfilmotheque.repository.FilmRepository;
import fr.eni.tpfilmotheque.repository.ParticipantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvisServiceImplData implements AvisService{

    private AvisRepository avisRepository ;


    public AvisServiceImplData(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public void createAvis(Avis avis){
        avisRepository.save(avis);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Avis> listeDesAvis() {
        return avisRepository.findAll();
    }
}
