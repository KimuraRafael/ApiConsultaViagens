package br.com.ifsp.ApiConsultaViagens.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "viagem_info")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viagemId;
    private String descricaoViagem;
    private Long qtd_assentos;

    @OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("viagem")
    private List<Itinerario> itinerarios;
    
    @OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("viagem")
    private List<Passagem> passagens;

   
	

	public Viagem() {}

    public Viagem(Long viagemId, String descricaoViagem, Long qtd_assentos ,List<Itinerario> itinerarios) {
        this.viagemId = viagemId;
        this.descricaoViagem = descricaoViagem;
        this.qtd_assentos = qtd_assentos;
        this.itinerarios = itinerarios;
    }

    public Long getViagemId() {
        return viagemId;
    }

    public void setViagemId(Long viagemId) {
        this.viagemId = viagemId;
    }

    public String getDescricaoViagem() {
        return descricaoViagem;
    }

    public void setDescricaoViagem(String descricaoViagem) {
        this.descricaoViagem = descricaoViagem;
    }

    public Long getQtd_assentos() {
		return qtd_assentos;
	}

	public void setQtd_assentos(Long qtd_assentos) {
		this.qtd_assentos = qtd_assentos;
	}

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }
    
    public List<Passagem> getPassagens() {
		return passagens;
	}

	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}
}



