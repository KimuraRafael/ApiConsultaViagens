package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifsp.ApiConsultaViagens.models.Viagem;
import br.com.ifsp.ApiConsultaViagens.repository.ApiConsultaViagensViagensRepository;

@Service
public class ImplViagemService implements ServiceViagem {

    private final ApiConsultaViagensViagensRepository viagemRepository;

    @Autowired
    public ImplViagemService(ApiConsultaViagensViagensRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    @Override
    public String createViagem(Viagem viagem) {
        viagemRepository.save(viagem);
        return "Viagem criada com sucesso!";
    }

    @Override
    public String updateViagem(Viagem viagem) {
        viagemRepository.save(viagem);
        return "Viagem atualizada com sucesso!";
    }

    @Override
    public String deleteViagem(Long viagemId) {
        viagemRepository.deleteById(viagemId);
        return "Viagem deletada com sucesso!";
    }

    @Override
    public Viagem getViagem(Long viagemId) {
        return viagemRepository.findById(viagemId).orElse(null);
    }

    @Override
    public List<Viagem> getAllViagem() {
        return viagemRepository.findAll();
    }
}
