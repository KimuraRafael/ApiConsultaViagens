package br.com.ifsp.ApiConsultaViagens.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="passagem_info")
public class Passagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passagemId;
    private String passagemOrigem;
    private String passagemDestino;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataCompra;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataChegada;
    private BigDecimal passagemValor;
    private String veiculo;
    
    @ManyToOne
    @JoinColumn(name = "viagem_id")
    @JsonIgnoreProperties("passagens")
    private Viagem viagem;
    

	public Passagem() {}

    public Passagem(Long passagemId, String passagemOrigem, String passagemDestino, LocalDateTime dataCompra,
                    LocalDateTime dataChegada, BigDecimal passagemValor, String veiculo) {
        this.passagemId = passagemId;
        this.passagemOrigem = passagemOrigem;
        this.passagemDestino = passagemDestino;
        this.dataCompra = dataCompra;
        this.dataChegada = dataChegada;
        this.passagemValor = passagemValor;
        this.veiculo = veiculo;
    }

    public Long getPassagemId() {
        return passagemId;
    }

    public void setPassagemId(Long passagemId) {
        this.passagemId = passagemId;
    }

    public String getPassagemOrigem() {
        return passagemOrigem;
    }

    public void setPassagemOrigem(String passagemOrigem) {
        this.passagemOrigem = passagemOrigem;
    }

    public String getPassagemDestino() {
        return passagemDestino;
    }

    public void setPassagemDestino(String passagemDestino) {
        this.passagemDestino = passagemDestino;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }

    public BigDecimal getPassagemValor() {
        return passagemValor;
    }

    public void setPassagemValor(BigDecimal passagemValor) {
        this.passagemValor = passagemValor;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
    public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

}

