package br.com.ifsp.ApiConsultaViagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifsp.ApiConsultaViagens.models.Viagem;
import br.com.ifsp.ApiConsultaViagens.repository.ApiConsultaViagensViagensRepository;

import java.util.Optional;

@RestController
@RequestMapping("/viagens")
public class ViagemAPIService {

    @Autowired
    private ApiConsultaViagensViagensRepository viagemRepository;

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
}




