package br.com.ifsp.ApiConsultaViagens.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ifsp.ApiConsultaViagens.models.Passagem;
import br.com.ifsp.ApiConsultaViagens.service.ServicePassagem;

@RestController
@RequestMapping("/passagens")
public class PassagemAPIService {

    private static final Logger logger = LoggerFactory.getLogger(PassagemAPIService.class);

    private  ServicePassagem servicePassagem;

    @Autowired
    public PassagemAPIService(ServicePassagem servicePassagem) {
        this.servicePassagem = servicePassagem;
    }

    @GetMapping("/{passagemId}")
    public Object getPassagem(@PathVariable Long passagemId) {
        logger.info("Chamando getPassagem com passagemId: " + passagemId);
        Passagem passagem = servicePassagem.getPassagem(passagemId);
        if (passagem != null) {
            return passagem;
        } else {
            return "Passagem não encontrada!";
        }
    }

    @GetMapping
    public List<Passagem> getAllPassagem() {
        return servicePassagem.getAllPassagem();
    }

    @PostMapping
    public String createPassagem(@RequestBody Passagem passagem) {
        logger.info("Chamando createPassagem com passagemId: " + passagem.getPassagemId());
        return servicePassagem.createPassagem(passagem);
    }

    @PutMapping
    public String updatePassagem(@RequestBody Passagem passagem) {
        logger.info("Chamando updatePassagem com passagemId: " + passagem.getPassagemId());
        return servicePassagem.updatePassagem(passagem);
    }

    @DeleteMapping("/{passagemId}")
    public String deletePassagem(@PathVariable Long passagemId) {
        logger.info("Chamando deletePassagem com passagemId: " + passagemId);
        return servicePassagem.deletePassagem(passagemId);
    }
}



