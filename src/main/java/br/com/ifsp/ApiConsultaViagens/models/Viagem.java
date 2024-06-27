package br.com.ifsp.ApiConsultaViagens.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "viagem_info")
public class Viagem {

    @Id
    private Long viagemId;
    private String descricaoViagem;

    @OneToMany(mappedBy = "viagem")
    @JsonIgnoreProperties("viagem")
    private List<Itinerario> itinerarios;

    public Viagem() {}

    public Viagem(Long viagemId, String descricaoViagem, List<Itinerario> itinerarios) {
        this.viagemId = viagemId;
        this.descricaoViagem = descricaoViagem;
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

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }
}



