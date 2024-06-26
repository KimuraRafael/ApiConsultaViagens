package br.com.ifsp.ApiConsultaViagens.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ifsp.ApiConsultaViagens.models.Viagem;
import br.com.ifsp.ApiConsultaViagens.service.ServiceViagem;

@RestController
@RequestMapping("/viagens")
public class ViagemAPIService {

    private static final Logger logger = LoggerFactory.getLogger(ViagemAPIService.class);

    private final ServiceViagem serviceViagem;

    @Autowired
    public ViagemAPIService(ServiceViagem serviceViagem) {
        this.serviceViagem = serviceViagem;
    }

    @GetMapping("/{viagemId}")
    public Object getViagem(@PathVariable Long viagemId) {
        logger.info("Chamando getViagem com viagemId: " + viagemId);
        Viagem viagem = serviceViagem.getViagem(viagemId);
        if (viagem != null) {
            return viagem;
        } else {
            return "Viagem não encontrada!";
        }
    }

    @GetMapping
    public List<Viagem> getAllViagem() {
        return serviceViagem.getAllViagem();
    }

    @PostMapping
    public String createViagem(@RequestBody Viagem viagem) {
        logger.info("Chamando createViagem com viagemId: " + viagem.getViagemId());
        return serviceViagem.createViagem(viagem);
    }

    @PutMapping
    public String updateViagem(@RequestBody Viagem viagem) {
        logger.info("Chamando updateViagem com viagemId: " + viagem.getViagemId());
        return serviceViagem.updateViagem(viagem);
    }

    @DeleteMapping("/{viagemId}")
    public String deleteViagem(@PathVariable Long viagemId) {
        logger.info("Chamando deleteViagem com viagemId: " + viagemId);
        return serviceViagem.deleteViagem(viagemId);
    }
}


