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

import br.com.ifsp.ApiConsultaViagens.DTO.PassagensPostDTO;
import br.com.ifsp.ApiConsultaViagens.models.Passagem;
import br.com.ifsp.ApiConsultaViagens.models.Usuario;
import br.com.ifsp.ApiConsultaViagens.models.Viagem;
import br.com.ifsp.ApiConsultaViagens.repository.PassagensRepository;
import br.com.ifsp.ApiConsultaViagens.repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

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
    public ResponseEntity<String> createPassagem2(@RequestBody PassagensPostDTO passagemDTO) {
        Long viagemId = passagemDTO.getViagemId();
        if (viagemId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID da Viagem não pode ser nulo");
        }
        
        Long usuarioId = passagemDTO.getUsuarioId();
        if (usuarioId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID do Usuário não pode ser nulo");
        }
        
        Viagem viagem = viagemRepository.findById(viagemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Viagem não encontrada"));
        
        Usuario user= usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));


        Passagem passagem = new Passagem();
        passagem.setViagem(viagem);
        passagem.setUser(user);
        passagem.setPassagemOrigem(passagemDTO.getPassagemOrigem());
        passagem.setPassagemDestino(passagemDTO.getPassagemDestino());
        passagem.setDataCompra(passagemDTO.getDataCompra());
        passagem.setDataChegada(passagemDTO.getDataChegada());
        passagem.setPassagemValor(passagemDTO.getPassagemValor());
        passagem.setVeiculo(passagemDTO.getVeiculo());

        passagemRepository.save(passagem);

        return ResponseEntity.ok("Passagem criada com sucesso: " + passagem.getPassagemId());
    }

    @PutMapping("/{passagemId}")
    public ResponseEntity<Passagem> updatePassagem(@PathVariable Long passagemId ,@RequestBody Passagem passagemAtualizada) {
       
        
        Optional<Passagem> optionalPassagem = passagemRepository.findById(passagemId);
        
        if (!optionalPassagem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Passagem passagem = optionalPassagem.get();
        passagem.setDataChegada(passagemAtualizada.getDataChegada());
        passagem.setDataCompra(passagemAtualizada.getDataCompra());
        passagem.setPassagemDestino(passagemAtualizada.getPassagemDestino());
        passagem.setPassagemOrigem(passagemAtualizada.getPassagemOrigem());
        passagem.setPassagemValor(passagemAtualizada.getPassagemValor());
        
        Passagem updatedpassagem = passagemRepository.save(passagem);
        return ResponseEntity.ok(updatedpassagem);
    }

    @DeleteMapping("/{passagemId}")
    public String deletePassagem(@PathVariable Long passagemId) {
        logger.info("Chamando deletePassagem com passagemId: " + passagemId);
        return servicePassagem.deletePassagem(passagemId);
    }
}



