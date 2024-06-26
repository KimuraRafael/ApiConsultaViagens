package br.com.ifsp.ApiConsultaViagens.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ifsp.ApiConsultaViagens.models.Itinerario;
import br.com.ifsp.ApiConsultaViagens.service.ServiceItinerario;

@RestController
@RequestMapping("/itinerarios")
public class ItinerarioAPIService {

    private static final Logger logger = LoggerFactory.getLogger(ItinerarioAPIService.class);

    private final ServiceItinerario serviceItinerario;

    @Autowired
    public ItinerarioAPIService(ServiceItinerario serviceItinerario) {
        this.serviceItinerario = serviceItinerario;
    }

    @GetMapping("/{id}")
    public Object getItinerario(@PathVariable Long id) {
        logger.info("Chamando getItinerario com id: " + id);
        Itinerario itinerario = serviceItinerario.getItinerario(id);
        if (itinerario != null) {
            return itinerario;
        } else {
            return "Itinerário não encontrado!";
        }
    }

    @GetMapping
    public List<Itinerario> getAllItinerario() {
        return serviceItinerario.getAllItinerario();
    }

    @PostMapping
    public String createItinerario(@RequestBody Itinerario itinerario) {
        logger.info("Chamando createItinerario com id: " + itinerario.getId());
        return serviceItinerario.createItinerario(itinerario);
    }

    @PutMapping
    public String updateItinerario(@RequestBody Itinerario itinerario) {
        logger.info("Chamando updateItinerario com id: " + itinerario.getId());
        return serviceItinerario.updateItinerario(itinerario);
    }

    @DeleteMapping("/{id}")
    public String deleteItinerario(@PathVariable Long id) {
        logger.info("Chamando deleteItinerario com id: " + id);
        return serviceItinerario.deleteItinerario(id);
    }
}
