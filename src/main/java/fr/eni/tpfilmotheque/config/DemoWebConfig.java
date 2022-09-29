package fr.eni.tpfilmotheque.config;

import fr.eni.tpfilmotheque.bo.Participant;
import fr.eni.tpfilmotheque.service.RealisateurService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Configuration
public class DemoWebConfig {

    @Bean
    @ApplicationScope
    public List<Participant> realisateurs(RealisateurService service){
        return service.getListeRealisateurs();
    }
}
