package br.com.ifsp.ApiConsultaViagens.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.ifsp.ApiConsultaViagens.DTO.PassagensDTO;
import br.com.ifsp.ApiConsultaViagens.models.Passagem;
import br.com.ifsp.ApiConsultaViagens.models.Viagem;
import br.com.ifsp.ApiConsultaViagens.repository.PassagensRepository;
import br.com.ifsp.ApiConsultaViagens.repository.ViagensRepository;
import br.com.ifsp.ApiConsultaViagens.service.ServicePassagem;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/passagens")
public class PassagemAPIService {

    private static final Logger logger = LoggerFactory.getLogger(PassagemAPIService.class);

    private  ServicePassagem servicePassagem;
    
    @Autowired
    private PassagensRepository passagemRepository;
    
    @Autowired 
    private ViagensRepository viagemRepository;

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
    public ResponseEntity<String> createPassagem2(@RequestBody PassagensDTO passagemDTO) {
        Long viagemId = passagemDTO.getViagemId();
        if (viagemId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID da Viagem não pode ser nulo");
        }
        
        Viagem viagem = viagemRepository.findById(viagemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Viagem não encontrada"));

        Passagem passagem = new Passagem();
        passagem.setViagem(viagem);
        passagem.setPassagemOrigem(passagemDTO.getPassagemOrigem());
        passagem.setPassagemDestino(passagemDTO.getPassagemDestino());
        passagem.setDataCompra(passagemDTO.getDataCompra());
        passagem.setDataChegada(passagemDTO.getDataChegada());
        passagem.setPassagemValor(passagemDTO.getPassagemValor());
        passagem.setVeiculo(passagemDTO.getVeiculo());

        passagemRepository.save(passagem);

        return ResponseEntity.ok("Passagem criada com sucesso: " + passagem.getPassagemId());
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



