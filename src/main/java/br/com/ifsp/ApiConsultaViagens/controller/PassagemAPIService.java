package br.com.ifsp.ApiConsultaViagens.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.ApiConsultaViagens.models.Passagem;

@RestController
@RequestMapping("/passagens")
public class PassagemAPIService {
	
	
	@GetMapping("{passagemId}")
	public Passagem getPassagem(Long passagemId) {
		
		
		return new Passagem((long)1, "Novo Horizonte", "Catanduva", LocalDateTime.now(), LocalDateTime.now(), new BigDecimal("50.50"), "Ônibus");
		
	}
	
	

}
