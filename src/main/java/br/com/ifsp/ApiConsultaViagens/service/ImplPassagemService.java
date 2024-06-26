package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsp.ApiConsultaViagens.ApiConsultaViagensApplication;
import br.com.ifsp.ApiConsultaViagens.models.Passagem;
import br.com.ifsp.ApiConsultaViagens.repository.ApiConsultaViagensRepository;

@Service
public class ImplPassagemService implements ServicePassagem {

    private ApiConsultaViagensRepository apiConsultaViagensRepository;

    @Autowired
    public ImplPassagemService(ApiConsultaViagensRepository apiConsultaViagensRepository) {
        this.apiConsultaViagensRepository = apiConsultaViagensRepository;
    }

    @Override
    public String createPassagem(Passagem passagem) {
        apiConsultaViagensRepository.save(passagem);
        return "Passagem criada com sucesso!";
    }

    @Override
    public String updatePassagem(Passagem passagem) {
        apiConsultaViagensRepository.save(passagem);
        return "Passagem atualizada com sucesso!";
    }

    @Override
    public String deletePassagem(Long passId) {
        apiConsultaViagensRepository.deleteById(passId);
        return "Passagem deletada com sucesso!";
    }

    @Override
    public Passagem getPassagem(Long passId) {
        return apiConsultaViagensRepository.findById(passId).orElse(null);
    }

    @Override
    public List<Passagem> getAllPassagem() {
        return apiConsultaViagensRepository.findAll();
    }
}


