package br.com.ifsp.ApiConsultaViagens.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String localParada;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "viagem_id")
    @JsonIgnoreProperties("itinerarios")
    private Viagem viagem;
    public Itinerario() {}

    public Itinerario(Long id, String descricao, String localParada, LocalDateTime dataHora, Viagem viagem) {
        this.id = id;
        this.descricao = descricao;
        this.localParada = localParada;
        this.dataHora = dataHora;
        this.viagem = viagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalParada() {
        return localParada;
    }

    public void setLocalParada(String localParada) {
        this.localParada = localParada;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
}
