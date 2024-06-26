package br.com.ifsp.ApiConsultaViagens.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "viagem_info")
public class Viagem {

    @Id
    private Long viagemId;
    private String descricaoViagem;

    public Viagem() {}

    public Viagem(Long viagemId, String descricaoViagem) {
        this.viagemId = viagemId;
        this.descricaoViagem = descricaoViagem;
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
}

