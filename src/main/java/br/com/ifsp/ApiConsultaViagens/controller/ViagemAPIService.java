package br.com.ifsp.ApiConsultaViagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifsp.ApiConsultaViagens.models.Viagem;
import br.com.ifsp.ApiConsultaViagens.repository.ViagensRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/viagens")
public class ViagemAPIService {

    @Autowired
    private ViagensRepository viagemRepository;

    @PostMapping
    public ResponseEntity<Viagem> createViagem(@RequestBody Viagem viagem) {
        Viagem savedViagem = viagemRepository.save(viagem);
        return ResponseEntity.ok(savedViagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> getViagem(@PathVariable Long id) {
        Optional<Viagem> viagem = viagemRepository.findById(id);
        return viagem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Viagem>> getAllViagens() {
        List<Viagem> viagens = viagemRepository.findAll();
        return ResponseEntity.ok(viagens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody Viagem viagemAtualizada) {
        Optional<Viagem> optionalViagem = viagemRepository.findById(id);
        
        if (!optionalViagem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Viagem viagem = optionalViagem.get();
        viagem.setDescricaoViagem(viagemAtualizada.getDescricaoViagem());
        viagem.setQtd_assentos(viagemAtualizada.getQtd_assentos());
        
        Viagem updatedViagem = viagemRepository.save(viagem);
        return ResponseEntity.ok(updatedViagem);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteViagem(@PathVariable Long id) {
        try {
            viagemRepository.deleteById(id);
            return ResponseEntity.ok("Viagem deletada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar viagem: " + e.getMessage());
        }
    }

}





