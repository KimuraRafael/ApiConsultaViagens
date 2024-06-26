package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import br.com.ifsp.ApiConsultaViagens.models.Viagem;

public interface ServiceViagem {
    String createViagem(Viagem viagem);
    String updateViagem(Viagem viagem);
    String deleteViagem(Long viagemId);
    Viagem getViagem(Long viagemId);
    List<Viagem> getAllViagem();
}
