package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import br.com.ifsp.ApiConsultaViagens.models.Itinerario;

public interface ServiceItinerario {
    String createItinerario(Itinerario itinerario);
    String updateItinerario(Itinerario itinerario);
    String deleteItinerario(Long id);
    Itinerario getItinerario(Long id);
    List<Itinerario> getAllItinerario();
}

