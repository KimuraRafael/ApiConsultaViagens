package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import br.com.ifsp.ApiConsultaViagens.models.Passagem;

public interface ServicePassagem {
    String createPassagem(Passagem passagem);
    String updatePassagem(Passagem passagem);
    String deletePassagem(Long passId);
    Passagem getPassagem(Long passId);
    List<Passagem> getAllPassagem();
}

