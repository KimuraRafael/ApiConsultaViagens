package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifsp.ApiConsultaViagens.models.Itinerario;
import br.com.ifsp.ApiConsultaViagens.repository.ItinerarioRepository;

@Service
public class ImplItinerarioService implements ServiceItinerario {

    private final ItinerarioRepository itinerarioRepository;

    @Autowired
    public ImplItinerarioService(ItinerarioRepository itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }

    @Override
    public String createItinerario(Itinerario itinerario) {
        itinerarioRepository.save(itinerario);
        return "Itinerário criado com sucesso!";
    }

    @Override
    public String updateItinerario(Itinerario itinerario) {
        itinerarioRepository.save(itinerario);
        return "Itinerário atualizado com sucesso!";
    }

    @Override
    public String deleteItinerario(Long id) {
        itinerarioRepository.deleteById(id);
        return "Itinerário deletado com sucesso!";
    }

    @Override
    public Itinerario getItinerario(Long id) {
        return itinerarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Itinerario> getAllItinerario() {
        return itinerarioRepository.findAll();
    }
}

